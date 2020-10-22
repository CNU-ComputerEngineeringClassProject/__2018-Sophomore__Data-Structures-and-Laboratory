
public class TestLinkedStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedStack a = new LinkedStack();
		
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(4);
		a.push(5);
		a.print();
		
		a.removesecond();
		a.print();
	
		
		a.reverse();
		a.print();

	}
}
