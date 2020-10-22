
public class Simulation {
	static int numServers; //서버 수
	static int numClients; // 클라이언트 수
	static int meanServiceTime; // 평균 서비스 시간
	static int meanInterarrivalTime; // 평균 도착시간
	static SimServer[] servers; // 서버수에 맞게 서버를 생성후 저장을 위한 servers 배열
	static Client[] clients; //클라이언트수에 맞게 클라이언트를 생성후 저장을 위한 clients 배열
	//static Queue queue = new SLinkedQueue(); 
	//위의 큐는 이소스 코드에서는 필요없다 (SimServer 클래스에서 큐를 생성하기때문)
	static java.util.Random randomArrival; //도착시간을 랜덤값으로 받기위함
	static java.util.Random randomService; //서비스시간을 랜덤값으로 받기위함
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		init(args);
		// 리스팅 6.3 참고
		run(); // 구현 해야 할 것.
		
	}

	static void init(String[] args) {
		if(args.length < 4) { //서버수, 클라이언트수, 평균서비스시간, 평균도착시간 이렇게 4가지를 입력받아햐하므로 가짓수가 4보다 적으면 오류메세지를 출력
			System.out.println("Usage : java Simulation <numServers> "  
					+ "<numClients> <meanServiceTime> <meanInterarrivalTime> ");
			System.out.println(" e.g.: java Simulation 3 100 12 4");
			System.exit(0);
		}

		numServers = Integer.parseInt(args[0]); //args의 0번째에 서버수를 저장한다.
		numClients = Integer.parseInt(args[1]); //args의 1번째에 클라이언트수를 저장한다.
		meanServiceTime = Integer.parseInt(args[2]); //args의 2번째에 평균서비스시간을 저장한다.
		meanInterarrivalTime = Integer.parseInt(args[3]); //args의 3번째에 평균도착시간을 저장한다.

		servers = new SimServer[numServers]; //servers배열의 크기를 지정한다.
		clients = new Client[numClients]; //clients배열의 크기를 지정한다.
		randomService = new ExponentialRandom(meanServiceTime); //평균서비스시간을 랜덤으로 입력받는다.
		randomArrival = new ExponentialRandom(meanInterarrivalTime); //평균 도착시간을 랜덤으로 입력받는다.
		//queue = new SLinkedQueue(); //큐는 SimServer에서 따로 생성하므로 이 소스는 필요가 없다.


		for(int j=0; j<numServers; j++) { //입력받은 서버수만큼 서버를 생성한다.
			servers[j] = new SimServer(j, randomService.nextInt());	
		}


		System.out.println("	Number of servers = " + numServers);
		System.out.println("	Number of clients = " + numClients);
		System.out.println("	Mean service time = " + meanServiceTime);
		System.out.println("	Mean interarrival time = " + meanInterarrivalTime);

		for(int j=0; j<numServers; j++) {		
			System.out.println("Mean service time for " + servers[j] + "=" + servers[j].getMeanServiceTime());
		}
	}

	static void run() {

		int i=0,j=0,lastServiceStopClient=0; 
		int sum=0;
		double average =1;
		int nextArrivalTime = randomArrival.nextInt(); 
		//다음 클라이언트의 도착시간을 랜덤값으로 정함. 처음이므로 첫번째 클라이언트의 도착시간을 랜덤으로 입력함.
		
		for ( int t=0;  ; t++ ) { //시간을 0부터 계속 1씩 증가하도록 반복문을 사용
			if (t==nextArrivalTime && i<numClients) { //시간t가 랜덤으로받은 다음도착시간과 일치하고 i가 입력받은 클라이언트수 보다 작을경우 if문 실행
				Client client = clients[i++] = new SimClient(i,t); //클라이언트 i번째 배열에  i+1의 id를 갖고, t시간에 도착하는 클라이언트를 만들어 저장하고, client를 생성하여 클라이언트 i번째 배열 값을 저장한다. (i를 하나 증가시킨다.) 
				servers[(i-1)%numServers].queue().add(client); // 클라이언트를 서버에 순서대로 넣는다.(i를 증가시켰으므로 -1한 상태로 서버수로 나눈 나머지의 값을 이용하여 각 순서에 맞는 서버의 큐에 들어간다.)  
				nextArrivalTime = t + randomArrival.nextInt(); // 다음 도착시간을 정의한다. (시간까지 흘러간시간t에 랜덤값을 더한다.)
				}

			for ( j=0;j<numServers; j++) { //j를 0부터 서버수보다 작을때 동안만 for문을 반복한다.
				Server server = servers[j]; //sever를 생성하여 severs j번째배열의 값을 저장한다. 
				if (t==server.getStopTime()) { //sever의 종료시간과 t와 일치할때,
					server.stopServing(t); //클라이언트에대한 서비스를 중지시키고 클라이언트를 null로 만든다.
					lastServiceStopClient++; //마지막으로 서비스 종료한 클라이언트까지의 수를 알기위해 변수를 하나 증가시킨다.
				}
				if (server.isIdle() && !servers[j].queue().isEmpty() ) { //server가 유휴상태이고, j번째 서버의 큐에 클라이언트가 있을경우
					Client client = (SimClient)servers[j].queue().remove(); // j번째 서버의 큐안에 있는 먼저 들어온 클라이언트를 제거한다.
					server.startServing(client,t);	//그리고 제거한 클라이언트를 서버에서 서비스를 시작한다.			
				}

			}
			if(lastServiceStopClient==numClients) { //마지막으로 서비스 종료한 클라이언트까지의 수가 입력한 클라이언트수와 일치할경우 프로그램을 종료하기위해 if문을 실행시킨다.
				
				for(i=0; i<numClients ;i++) { // i가 0부터 클라이언트 수보다 작을때까지 for문을 실행시킨다.
					SimClient client = (SimClient)clients[i]; // i+1번째 클라이언트를 클라이언트 i번째 배열의 값으로 client에 저장한다.
					sum = sum +(client.getStoptime() - client.getStartTime()); // 총 서비스 시간의 합을 알기위해 client 서비스 종료시간에서 서비스 시작시간을 빼고 원래 sum값을 더해 sum에 넣는다.
					}
				
					average = (double) sum / numClients; // 평균을 sum에 클라이언트수를 나눠서 구한다.
					System.out.println();
					System.out.println("평균 : "+average); //평균을 출력한다.
				
				break ;} //for문을 나온다 break를 하지 않으면 시간t가 계속해서 증가할것이다.
		}
	}
}


