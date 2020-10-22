import java.util.ArrayList;


public class ArrayQueue implements Queue{

	ArrayList<Object> aQueue = new ArrayList<Object>();
	
	
	@Override
	public Object first() {
		// TODO Auto-generated method stub
		if(aQueue.isEmpty()) {
			System.out.print("Queue가 비어있습니다. : ");
			return null;
		}
		else {
			return aQueue.get(0);
		}
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		if(aQueue.isEmpty()) {
			System.out.print("Queue가 비어있습니다. : ");
			return null;
		}
		else {
			return aQueue.remove(0);
		}
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		aQueue.add(size(),object);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return aQueue.size();
	}

}
