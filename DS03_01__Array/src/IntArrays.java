
public class IntArrays {


	private static java.util.Random random = new java.util.Random();

	private int []a;



	public IntArrays (int n) {

		this.a= new int[n];

		for (int i=0;i<n/2;i++) {
			a[i] = random.nextInt(n-1+1)+1;
		}

		System.out.println("���� "+ n +"�� �迭�� �����Ͽ����ϴ�.");
		print();
	}




	public void add (int x) {


		if(a[a.length-1]!=0) {	//�迭�� ���������� ��� ũ�Ⱑ 2���� aa�迭�� �����Ͽ� �������� x�� �����ϰ� a=aa�� �Ͽ� a�迭�� �����Ѵ�.

			int[] aa = new int[a.length*2];

			System.arraycopy(a, 0, aa, 0, a.length); 

			aa[a.length]=x;

			System.out.println("������ "+ x +"�� ������ �Ϸ�Ǿ����ϴ�.");
			a=aa;
			print();

		}
		else {
			int i=0;

			for(int j=0 ; j<a.length-1;j++) {
				if(a[j]!=0) {
					i=j;
				}
			}
			
			a[i+1] = x;


			System.out.println("������ "+ x +"�� ������ �Ϸ�Ǿ����ϴ�.");
			print();
		}


	}




	public void remove(int x) {

	int check=0;
		for(int i=0;i<a.length;i++) { 
				if(a[i]==x) { 
					
					for (int j=i;j<a.length-1;j++) { 
						a[j] = a[j+1]; 
						check++;
				} 
					break;}
				}
		
		if(check==0) {
			System.out.println("������ "+ x +"�� �迭�� �������� �ʽ��ϴ�.");
			}
		
		else{
			System.out.println("������ "+ x +"�� ������ �Ϸ�Ǿ����ϴ�.");
			print();
		}

		
	}


	public void print () {

		int num=0;
		
		System.out.print("�迭 ���� : ");
		for(int i=0 ; i<a.length ; i++) {

			if(a[i]!=0) {
				num++;
				System.out.print(a[i]+" ");
			}
		}
		
		
		System.out.print(", ũ��: ");
		System.out.println(num);


	}
}






