
public class LinkedStack {

	private Node top;
	private int size;
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public int peek() {
		if(isEmpty()) throw new java.util.NoSuchElementException();
		return top.value;
	}
	
	public Node pop() {
		if(isEmpty()) throw new java.util.NoSuchElementException();
		
		Node oldTop = new Node(top.value);
		top = top.next;
		
		--size;
		
		System.out.println("pop : " + oldTop.value);

		return oldTop;
	}
	
	public void push(int value) {		
		top = new Node(value, top);
		++size;
		
		System.out.println("Push : " + value);
	}
	
	public int size() {
		return size;
	}
	
	public void reverse() {

		System.out.println("reverse()");
		
		Node next_reverse = top.next; //�ڽ��� next�� �� ��带 ���ϰ� �ϱ����� ���
		Node beforeReverse_Next= next_reverse.next; // next_reverse�� next�� ����Ű�� ��带 �ٲ����ν� ���� ���ϴ� ��带 ����Ű�°� �������Ƿ� ����Ű���� �ϱ����� ��� 
		Node topcopy = top; //�Ǹ��������� �Ű����� top ��� ���� top�ڸ��� ���� topcopy
		
		
		while(top!=next_reverse && top!=beforeReverse_Next) {
			
			if(next_reverse.next==null) {
				next_reverse.next = top;
				top=next_reverse;
			}
		
		else if(beforeReverse_Next.next==null) {
			next_reverse.next = top;
			top=next_reverse;
			next_reverse=beforeReverse_Next;
		}
		else {
			next_reverse.next = top;
			top=next_reverse;
			next_reverse=beforeReverse_Next;
			beforeReverse_Next=beforeReverse_Next.next;	
			}
		}
		
		topcopy.next = null;
		
	}
	
	public Node removesecond() {
		
		System.out.println("removesecond()");

		if(isEmpty() || size == 1) throw new java.util.NoSuchElementException();

		Node oldSecondTop = new Node(top.next.value);
		top.next = top.next.next;
		
		--size;
		
		System.out.println("Removed Node : " + oldSecondTop.value);

		return oldSecondTop;
	}
	
	public String toString(int value) {
		StringBuffer buf = new StringBuffer (Integer.toString(value));
		return buf.toString();
		
	}
	
	public void print() {
		
		Node p = top;
		
		System.out.print("Current Elements of Stack : top");
		
		while (p!=null) {
			
			System.out.print(" -> "+toString(p.value));
			p=p.next;
		}
		System.out.println();

	}
}
