
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
		
		Node next_reverse = top.next; //자신의 next가 전 노드를 향하게 하기위한 노드
		Node beforeReverse_Next= next_reverse.next; // next_reverse가 next가 가리키는 노드를 바꿈으로써 전에 향하던 노드를 가리키는게 없어지므로 가리키도록 하기위한 노드 
		Node topcopy = top; //맨마지막노드로 옮겨지는 top 대신 원래 top자리에 있을 topcopy
		
		
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
