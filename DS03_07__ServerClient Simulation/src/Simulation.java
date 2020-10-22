
public class Simulation {
	static int numServers; //���� ��
	static int numClients; // Ŭ���̾�Ʈ ��
	static int meanServiceTime; // ��� ���� �ð�
	static int meanInterarrivalTime; // ��� �����ð�
	static SimServer[] servers; // �������� �°� ������ ������ ������ ���� servers �迭
	static Client[] clients; //Ŭ���̾�Ʈ���� �°� Ŭ���̾�Ʈ�� ������ ������ ���� clients �迭
	//static Queue queue = new SLinkedQueue(); 
	//���� ť�� �̼ҽ� �ڵ忡���� �ʿ���� (SimServer Ŭ�������� ť�� �����ϱ⶧��)
	static java.util.Random randomArrival; //�����ð��� ���������� �ޱ�����
	static java.util.Random randomService; //���񽺽ð��� ���������� �ޱ�����
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		init(args);
		// ������ 6.3 ����
		run(); // ���� �ؾ� �� ��.
		
	}

	static void init(String[] args) {
		if(args.length < 4) { //������, Ŭ���̾�Ʈ��, ��ռ��񽺽ð�, ��յ����ð� �̷��� 4������ �Է¹޾����ϹǷ� �������� 4���� ������ �����޼����� ���
			System.out.println("Usage : java Simulation <numServers> "  
					+ "<numClients> <meanServiceTime> <meanInterarrivalTime> ");
			System.out.println(" e.g.: java Simulation 3 100 12 4");
			System.exit(0);
		}

		numServers = Integer.parseInt(args[0]); //args�� 0��°�� �������� �����Ѵ�.
		numClients = Integer.parseInt(args[1]); //args�� 1��°�� Ŭ���̾�Ʈ���� �����Ѵ�.
		meanServiceTime = Integer.parseInt(args[2]); //args�� 2��°�� ��ռ��񽺽ð��� �����Ѵ�.
		meanInterarrivalTime = Integer.parseInt(args[3]); //args�� 3��°�� ��յ����ð��� �����Ѵ�.

		servers = new SimServer[numServers]; //servers�迭�� ũ�⸦ �����Ѵ�.
		clients = new Client[numClients]; //clients�迭�� ũ�⸦ �����Ѵ�.
		randomService = new ExponentialRandom(meanServiceTime); //��ռ��񽺽ð��� �������� �Է¹޴´�.
		randomArrival = new ExponentialRandom(meanInterarrivalTime); //��� �����ð��� �������� �Է¹޴´�.
		//queue = new SLinkedQueue(); //ť�� SimServer���� ���� �����ϹǷ� �� �ҽ��� �ʿ䰡 ����.


		for(int j=0; j<numServers; j++) { //�Է¹��� ��������ŭ ������ �����Ѵ�.
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
		//���� Ŭ���̾�Ʈ�� �����ð��� ���������� ����. ó���̹Ƿ� ù��° Ŭ���̾�Ʈ�� �����ð��� �������� �Է���.
		
		for ( int t=0;  ; t++ ) { //�ð��� 0���� ��� 1�� �����ϵ��� �ݺ����� ���
			if (t==nextArrivalTime && i<numClients) { //�ð�t�� �������ι��� ���������ð��� ��ġ�ϰ� i�� �Է¹��� Ŭ���̾�Ʈ�� ���� ������� if�� ����
				Client client = clients[i++] = new SimClient(i,t); //Ŭ���̾�Ʈ i��° �迭��  i+1�� id�� ����, t�ð��� �����ϴ� Ŭ���̾�Ʈ�� ����� �����ϰ�, client�� �����Ͽ� Ŭ���̾�Ʈ i��° �迭 ���� �����Ѵ�. (i�� �ϳ� ������Ų��.) 
				servers[(i-1)%numServers].queue().add(client); // Ŭ���̾�Ʈ�� ������ ������� �ִ´�.(i�� �����������Ƿ� -1�� ���·� �������� ���� �������� ���� �̿��Ͽ� �� ������ �´� ������ ť�� ����.)  
				nextArrivalTime = t + randomArrival.nextInt(); // ���� �����ð��� �����Ѵ�. (�ð����� �귯���ð�t�� �������� ���Ѵ�.)
				}

			for ( j=0;j<numServers; j++) { //j�� 0���� ���������� ������ ���ȸ� for���� �ݺ��Ѵ�.
				Server server = servers[j]; //sever�� �����Ͽ� severs j��°�迭�� ���� �����Ѵ�. 
				if (t==server.getStopTime()) { //sever�� ����ð��� t�� ��ġ�Ҷ�,
					server.stopServing(t); //Ŭ���̾�Ʈ������ ���񽺸� ������Ű�� Ŭ���̾�Ʈ�� null�� �����.
					lastServiceStopClient++; //���������� ���� ������ Ŭ���̾�Ʈ������ ���� �˱����� ������ �ϳ� ������Ų��.
				}
				if (server.isIdle() && !servers[j].queue().isEmpty() ) { //server�� ���޻����̰�, j��° ������ ť�� Ŭ���̾�Ʈ�� �������
					Client client = (SimClient)servers[j].queue().remove(); // j��° ������ ť�ȿ� �ִ� ���� ���� Ŭ���̾�Ʈ�� �����Ѵ�.
					server.startServing(client,t);	//�׸��� ������ Ŭ���̾�Ʈ�� �������� ���񽺸� �����Ѵ�.			
				}

			}
			if(lastServiceStopClient==numClients) { //���������� ���� ������ Ŭ���̾�Ʈ������ ���� �Է��� Ŭ���̾�Ʈ���� ��ġ�Ұ�� ���α׷��� �����ϱ����� if���� �����Ų��.
				
				for(i=0; i<numClients ;i++) { // i�� 0���� Ŭ���̾�Ʈ ������ ���������� for���� �����Ų��.
					SimClient client = (SimClient)clients[i]; // i+1��° Ŭ���̾�Ʈ�� Ŭ���̾�Ʈ i��° �迭�� ������ client�� �����Ѵ�.
					sum = sum +(client.getStoptime() - client.getStartTime()); // �� ���� �ð��� ���� �˱����� client ���� ����ð����� ���� ���۽ð��� ���� ���� sum���� ���� sum�� �ִ´�.
					}
				
					average = (double) sum / numClients; // ����� sum�� Ŭ���̾�Ʈ���� ������ ���Ѵ�.
					System.out.println();
					System.out.println("��� : "+average); //����� ����Ѵ�.
				
				break ;} //for���� ���´� break�� ���� ������ �ð�t�� ����ؼ� �����Ұ��̴�.
		}
	}
}


