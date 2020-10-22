
public class ArrayQueue implements Queue {

	private Object[] a;
	private int front,rear,size;

	public ArrayQueue(int capacity) {
		a= new Object[capacity];
		this.front = -1;
		this.rear = -1;
		this.size=0;
	}

	@Override
	public void add (Object object) {
		// TODO Auto-generated method stub
		if(isFull()){	
			System.out.println("Array Queue°¡ °¡µæ Ã¡½À´Ï´Ù.");
		}
		else {
			a[++rear] = object;
			size++;}
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			return a[front+1];
		}
		else {return null;}
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		Object remove_element=null;
		if(!isEmpty()) {
			remove_element=a[++front];
			a[front]=null;
			size--;
		}
		return remove_element;
	}

	public boolean isEmpty() {
		if(size == 0 && (front == rear)) {
			return true;
		}
		else return false;

	}
	public boolean isFull() {
		if(rear==a.length-1) {return true;}
		else {return false;}
	}

	public void print(){
		System.out.print("* Array Queue = [");
		for(int i = 0; i<=rear ; i++) {
			System.out.print(" "+toString(a[i])+" ");
			if(i<rear) {System.out.print("|");}
		}
		System.out.println("] (front: "+front+", rear: "+rear+")");



	}

	public String toString(Object object) {
		if(object==null) {return null;}
		else {
			StringBuffer buf = new StringBuffer (object.toString());
			return buf.toString();
		}

	}

}
