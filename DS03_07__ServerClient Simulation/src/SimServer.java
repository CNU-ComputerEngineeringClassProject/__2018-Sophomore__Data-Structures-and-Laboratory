
public class SimServer implements Server {
	
	private Client client;
	private int id, meanServiceTime, stopTime = -1;
	private java.util.Random random;
	private Queue queue;
	
	public SimServer(int id, int meanServiceTime) {
		// TODO Auto-generated constructor stub
		this.id = id; // 서버의 id (실습과제에서 서버 A,B,C,D를 나타내기 위한 id숫자)
		this.meanServiceTime = meanServiceTime; //평균 서비스시간
		this.random = new ExponentialRandom(meanServiceTime); //랜덤값을 입력받음
		this.queue = new SLinkedQueue();
	}
	
	public Queue queue() { return this.queue; }
	
	@Override
	public int getMeanServiceTime() { //서버의 meanServerTime을 반환. 평균서비스 시간을 의미
		// TODO Auto-generated method stub
		return meanServiceTime;
	}

	@Override
	public int getStopTime() { //서버가 서비스를 중지한 시간을 반환
		// TODO Auto-generated method stub
		return stopTime;
	}

	@Override
	public boolean isIdle() { // 서버의 유후 상태 여부를 반환 . 서버에 클라이언트가 있는지 없는지.
		// TODO Auto-generated method stub
		return client == null;
	}

	@Override
	public void startServing(Client client, int t) { // 클라이언트 c에 대한 서비스를 시작
		// TODO Auto-generated method stub
		this.client = client;
		this.client.setStartTime(t);
		this.stopTime = t + random.nextInt();
		System.out.println(this + " started serving " + client + " at time " + t + " and will finish at time " + stopTime);
	}

	@Override
	public void stopServing(int t) { // 클라이언트에 대한 서비스를 중지.
		// TODO Auto-generated method stub
		client.setStopTime(t);
		System.out.println(this + " stopped serving " + client + " at time " + t);
		client = null;
	}
	
	public String toString() { // id 숫자에 맞는 알파벳을 가지고 서버의 이름을 쓴다
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return " Server " + s.charAt(id);
	}
	

}
