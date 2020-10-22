
public class BigInt {
	private Node start;

	private static class Node{
		Node next;
		int digit;
		Node(int digit) {
			this.digit =digit;
		}
	}

	public BigInt(int n) {
		if(n<0) throw new IllegalArgumentException(n+"<0"); 

		start = new Node(n%10);
		Node p = start;
		n/=10;
		while(n>0) {
			p=p.next = new Node(n%10);
			n/=10;
		}
	}

	//끝에서 부터 출력하기 위한 메소드 5 4 3 2 1    start가 12345 순서로 가리키지만 출력은 반대로..
	public String toString() {
		StringBuffer buf = new StringBuffer (Integer.toString(start.digit));

		Node p= start.next;

		while(p!=null) {
			buf.insert(0, Integer.toString(p.digit));
			p=p.next;
		}	
		return buf.toString();
	}


	public BigInt multiplyone (BigInt y) {
		Node p = start;
		Node q= y.start;

		int n = p.digit * q.digit;

		BigInt z= new BigInt (n%10);
		Node r = z.start;
		p=p.next;


		while(p!=null) {
			n= n/10 + ( p.digit * q.digit) ;
			r.next = new Node(n%10);
			p=p.next;
			r=r.next;
		}

		if(p==null&& (n/10) !=0) {
			r.next = new Node(n/10);
		}


		return z;

	}

	public BigInt multiply (BigInt y) {

		Node q= y.start; //일의자리수
		BigInt b = new BigInt(q.digit); //곱해지는 수의 일의 자리수
		BigInt z = new BigInt(1); //곱해서 나온 것끼리 더해서 나오는 수
		Node p = new Node(0); // 0 노드를 가리키는 노드p를 만든다. 
		BigInt c = new BigInt(0); // 곱해서 나온수
		
		z=multiplyone(b); //곱하는 수와 곱해지는 수의 일의자리수를 곱한다.
		
		q=q.next; //십의자리수로 이동
		b = new BigInt(q.digit); //곱해지는 수의 십의자리수
		c=multiplyone(b); //곱하는 수와 곱해지는 수의 십의 자리수를 곱한다.
		
		p.next = c.start; //0노드의 next로 c.start를 가리킨다.
		c.start=p; // c.start는 노드 p를 가리킨다.
		z=z.plus(c); // z에 있던 수와 c를 더한다.
		
		q=q.next;
		
		int i=1;
		
		while(q!=null) {
			i++;
			b= new BigInt(q.digit);
			c=multiplyone(b);
			for(int j=0;j<i;j++) {
			p = new Node(0);
				Node x= c.start;
				p.next = c.start;
				x=p;
				c.start = x;
				
			}
					
			z=z.plus(c);
			q=q.next;
		}

		return z;
	}

	public BigInt plus(BigInt y) {
		Node p = start, q = y.start;
		int n = p.digit + q.digit;
		BigInt z = new BigInt(n%10);
		Node r=z.start;
		p = p.next;
		q = q.next;
		while (p != null && q != null) {
			n = n/10 + p.digit + q.digit;
			r.next = new Node(n%10);
			p = p.next;
			q = q.next;
			r = r.next;
		}

		while (p != null) {
			n = n/10 + p.digit;
			r.next = new Node(n%10);
			p = p.next;
			r = r.next;
		}
		while (q != null) {
			n = n/10 + q.digit;
			r.next = new Node(n%10);
			q = q.next;
			r = r.next;
		}
		if (n > 9)
			r.next = new Node(n/10);
		return z;
	}


}
