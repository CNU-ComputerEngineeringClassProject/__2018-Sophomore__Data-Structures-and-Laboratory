
public interface Point {


	public double getX();
	//������ : x�� ������� ����
	//���� : x�� ��ǥ
	public double getY();
	//������ : y�� ������� ����
	//���� : y�� ��ǥ
	
	public void setX(double x);
	//������ : x��ǥ�� �־��� ���� ����
	public void setY(double y);
	//������ : y��ǥ�� �־��� ���� ����
	
	public void moveTo(double xMove,double yMove);
	//������ : x��ǥ�� y��ǥ�� ���� �־��� ���� ���Ѵ�.
	public void scaleTo(double nTimes);
	//������ : 0 < nTimes (nTimes�� ������� ������ �Ѵ�.)
	//������ : x,y��ǥ�� �־��� ���� ���Ѵ�.

}
