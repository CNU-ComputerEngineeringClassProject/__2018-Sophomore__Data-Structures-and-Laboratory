
public class SimClient  implements Client {

	int id, arrivalTime = -1, startTime = -1, stoptime = -1;
	
	public SimClient(int id, int t) {
		// TODO Auto-generated constructor stub
		this.id = id;
		arrivalTime = t;
		System.out.println(this + " arrived at time " + t);
	}
	@Override
	public int getStartTime() { // 클라이언트의 서비스가 시작된 시간을 반환.
		return startTime;
	}
	@Override
	public int getStoptime() { // 클라이언트의 서비스가 종료된 시간을 반환.
		return stoptime;
	}
	
	@Override
	public void setStartTime(int t) {  // 클라이언트의 서비스가 시작된 시간을 t로 설정
		// TODO Auto-generated method stub
		this.startTime = t;
	}

	@Override
	public void setStopTime(int t) { // 클라이언트의 서비스가 종료된 시간을 t로 설정
		// TODO Auto-generated method stub
		this.stoptime = t;
	}
	
	public String toString() { //클라이언트 id를 반환. (이는 숫자로 표현됨)
		return "Client " + id;
	}

}
