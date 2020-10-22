
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

	//������ ���� ����ϱ� ���� �޼ҵ� 5 4 3 2 1    start�� 12345 ������ ����Ű���� ����� �ݴ��..
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

		Node q= y.start; //�����ڸ���
		BigInt b = new BigInt(q.digit); //�������� ���� ���� �ڸ���
		BigInt z = new BigInt(1); //���ؼ� ���� �ͳ��� ���ؼ� ������ ��
		Node p = new Node(0); // 0 ��带 ����Ű�� ���p�� �����. 
		BigInt c = new BigInt(0); // ���ؼ� ���¼�
		
		z=multiplyone(b); //���ϴ� ���� �������� ���� �����ڸ����� ���Ѵ�.
		
		q=q.next; //�����ڸ����� �̵�
		b = new BigInt(q.digit); //�������� ���� �����ڸ���
		c=multiplyone(b); //���ϴ� ���� �������� ���� ���� �ڸ����� ���Ѵ�.
		
		p.next = c.start; //0����� next�� c.start�� ����Ų��.
		c.start=p; // c.start�� ��� p�� ����Ų��.
		z=z.plus(c); // z�� �ִ� ���� c�� ���Ѵ�.
		
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
