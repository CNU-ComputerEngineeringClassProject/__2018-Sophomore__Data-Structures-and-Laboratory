
public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue a = new ArrayQueue(10);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.first();
		a.print();
		
		a.remove();
		a.remove();
		a.print();
		
		SLinkedQueue b = new SLinkedQueue();
		b.add(6);
		b.add(7);
		b.add(8);
		b.add(9);
		b.print();
		
		b.remove();
		b.remove();
		b.remove();
		b.remove();
		b.print();
		
		b.add(10);
		b.add(11);
		b.add(12);
		b.print();
		
		b.toArrayQueue().print();
		
	}

}
