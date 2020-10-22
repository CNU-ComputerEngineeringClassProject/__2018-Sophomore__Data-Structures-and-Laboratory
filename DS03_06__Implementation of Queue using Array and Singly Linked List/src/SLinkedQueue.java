
public class SLinkedQueue implements Queue {
	
	private Node head;
	private Node rear;
	private int size;

	
	private static class Node{
		Node next;
		Object object;
		Node(Object object) {
			this.object =object;
		}
	}
	
	public SLinkedQueue() {
	
		this.size=0;
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			head = new Node(object);
			rear = head;
		}
		else {
			rear.next =  new Node(object);
			rear = rear.next;
		}
		size++;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return head.object;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		Object object = null;
		if(isEmpty()) {}
		else {object = head.object;
			head = head.next;
			size--;}
		return object;
	}

	
	public boolean isEmpty(){
		if(size == 0) {return true;}
		else return false;
	}
	
	
	public void print(){
		Node p=head;
		System.out.print("* Singly Linked Queue = head");
		while(p!=null){
			System.out.print(" -> "+toString(p.object));
			p = p.next;
		}
		System.out.println();
		
	}
	
	public String toString(Object object) {
		StringBuffer buf = new StringBuffer (object.toString());
			return buf.toString();
	}
	
	public ArrayQueue toArrayQueue() {
		ArrayQueue aa=new ArrayQueue(size);
		Node p=head;
		while(p!=null) {
			aa.add(p.object);
			p=p.next;
		}
		System.out.println("[Change from SLinked_Q to Array_Q]");
		return aa;}

}
