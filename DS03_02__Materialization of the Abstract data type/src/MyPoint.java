
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
		
		System.out.println("[move] x축으로 "+xMove+", y축으로 "+yMove+"만큼 이동 완료 하였습니다.");

		
	}

	@Override
	public void scaleTo(double nTimes) {
		if(nTimes<=0) {
			System.out.println("[Error] 입력하신 "+nTimes+"는 양수가 아니므로 조건에 어긋납니다.");
		}
		else {
			this.xCoordinates = this.xCoordinates*nTimes;
			this.yCoordinates = this.yCoordinates*nTimes;
			System.out.println("[scale] 좌표에 "+nTimes+"배를 하였습니다.");

		}

		
	}
	}


