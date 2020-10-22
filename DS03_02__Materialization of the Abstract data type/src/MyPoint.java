
public class MyPoint implements Point{
	
	private double xCoordinates=0;
	private double yCoordinates=0;
	

	@Override
	public double getX() {
		return this.xCoordinates;
	}

	@Override
	public double getY() {
		return this.yCoordinates;
	}

	@Override
	public void setX(double x) {
		this.xCoordinates = x;
	}

	@Override
	public void setY(double y) {
		this.yCoordinates = y;
	}

	@Override
	public void moveTo(double xMove, double yMove) {
		this.xCoordinates = this.xCoordinates+xMove;
		this.yCoordinates = this.yCoordinates+yMove;
		
		System.out.println("[move] x������ "+xMove+", y������ "+yMove+"��ŭ �̵� �Ϸ� �Ͽ����ϴ�.");

		
	}

	@Override
	public void scaleTo(double nTimes) {
		if(nTimes<=0) {
			System.out.println("[Error] �Է��Ͻ� "+nTimes+"�� ����� �ƴϹǷ� ���ǿ� ��߳��ϴ�.");
		}
		else {
			this.xCoordinates = this.xCoordinates*nTimes;
			this.yCoordinates = this.yCoordinates*nTimes;
			System.out.println("[scale] ��ǥ�� "+nTimes+"�踦 �Ͽ����ϴ�.");

		}

		
	}
	}


