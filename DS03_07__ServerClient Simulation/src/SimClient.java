
public class SimClient  implements Client {

	int id, arrivalTime = -1, startTime = -1, stoptime = -1;
	
	public SimClient(int id, int t) {
		// TODO Auto-generated constructor stub
		this.id = id;
		arrivalTime = t;
		System.out.println(this + " arrived at time " + t);
	}
	@Override
	public int getStartTime() { // Ŭ���̾�Ʈ�� ���񽺰� ���۵� �ð��� ��ȯ.
		return startTime;
	}
	@Override
	public int getStoptime() { // Ŭ���̾�Ʈ�� ���񽺰� ����� �ð��� ��ȯ.
		return stoptime;
	}
	
	@Override
	public void setStartTime(int t) {  // Ŭ���̾�Ʈ�� ���񽺰� ���۵� �ð��� t�� ����
		// TODO Auto-generated method stub
		this.startTime = t;
	}

	@Override
	public void setStopTime(int t) { // Ŭ���̾�Ʈ�� ���񽺰� ����� �ð��� t�� ����
		// TODO Auto-generated method stub
		this.stoptime = t;
	}
	
	public String toString() { //Ŭ���̾�Ʈ id�� ��ȯ. (�̴� ���ڷ� ǥ����)
		return "Client " + id;
	}

}
