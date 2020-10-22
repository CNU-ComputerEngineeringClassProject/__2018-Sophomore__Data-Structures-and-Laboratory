
public class TestMyPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyPoint myPoint = new MyPoint();
		
		myPoint.setX(-1);
		myPoint.setY(3);
		
		System.out.println("ÇöÀç ÁÂÇ¥ : ("	+myPoint.getX()+", "+	myPoint.getY()+")");

		myPoint.moveTo(2, -5);		
		System.out.println("ÇöÀç ÁÂÇ¥ : ("	+myPoint.getX()+", "+	myPoint.getY()+")");
		
		myPoint.scaleTo(-2);
		System.out.println("ÇöÀç ÁÂÇ¥ : ("	+myPoint.getX()+", "+	myPoint.getY()+")");
		
		myPoint.scaleTo(2);
		System.out.println("ÇöÀç ÁÂÇ¥ : ("	+myPoint.getX()+", "+	myPoint.getY()+")");
	}

}
