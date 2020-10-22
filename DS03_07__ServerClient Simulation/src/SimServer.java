
public class SimServer implements Server {
	
	private Client client;
	private int id, meanServiceTime, stopTime = -1;
	private java.util.Random random;
	private Queue queue;
	
	public SimServer(int id, int meanServiceTime) {
		// TODO Auto-generated constructor stub
		this.id = id; // ������ id (�ǽ��������� ���� A,B,C,D�� ��Ÿ���� ���� id����)
		this.meanServiceTime = meanServiceTime; //��� ���񽺽ð�
		this.random = new ExponentialRandom(meanServiceTime); //�������� �Է¹���
		this.queue = new SLinkedQueue();
	}
	
	public Queue queue() { return this.queue; }
	
	@Override
	public int getMeanServiceTime() { //������ meanServerTime�� ��ȯ. ��ռ��� �ð��� �ǹ�
		// TODO Auto-generated method stub
		return meanServiceTime;
	}

	@Override
	public int getStopTime() { //������ ���񽺸� ������ �ð��� ��ȯ
		// TODO Auto-generated method stub
		return stopTime;
	}

	@Override
	public boolean isIdle() { // ������ ���� ���� ���θ� ��ȯ . ������ Ŭ���̾�Ʈ�� �ִ��� ������.
		// TODO Auto-generated method stub
		return client == null;
	}

	@Override
	public void startServing(Client client, int t) { // Ŭ���̾�Ʈ c�� ���� ���񽺸� ����
		// TODO Auto-generated method stub
		this.client = client;
		this.client.setStartTime(t);
		this.stopTime = t + random.nextInt();
		System.out.println(this + " started serving " + client + " at time " + t + " and will finish at time " + stopTime);
	}

	@Override
	public void stopServing(int t) { // Ŭ���̾�Ʈ�� ���� ���񽺸� ����.
		// TODO Auto-generated method stub
		client.setStopTime(t);
		System.out.println(this + " stopped serving " + client + " at time " + t);
		client = null;
	}
	
	public String toString() { // id ���ڿ� �´� ���ĺ��� ������ ������ �̸��� ����
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return " Server " + s.charAt(id);
	}
	

}
