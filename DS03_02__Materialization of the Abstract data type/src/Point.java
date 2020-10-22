
public interface Point {


	public double getX();
	//후조건 : x는 변경되지 않음
	//리턴 : x의 좌표
	public double getY();
	//후조건 : y는 변경되지 않음
	//리턴 : y의 좌표
	
	public void setX(double x);
	//후조건 : x좌표에 주어진 값을 가짐
	public void setY(double y);
	//후조건 : y좌표에 주어진 값을 가짐
	
	public void moveTo(double xMove,double yMove);
	//후조건 : x좌표와 y좌표에 각각 주어진 값을 더한다.
	public void scaleTo(double nTimes);
	//선조건 : 0 < nTimes (nTimes가 양수값을 가져야 한다.)
	//후조건 : x,y좌표에 주어진 값을 곱한다.

}
