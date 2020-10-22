
public class IntArrays {


	private static java.util.Random random = new java.util.Random();

	private int []a;



	public IntArrays (int n) {

		this.a= new int[n];

		for (int i=0;i<n/2;i++) {
			a[i] = random.nextInt(n-1+1)+1;
		}

		System.out.println("길이 "+ n +"인 배열을 생성하였습니다.");
		print();
	}




	public void add (int x) {


		if(a[a.length-1]!=0) {	//배열이 가득차있을 경우 크기가 2배인 aa배열을 생성하여 복사한후 x를 삽입하고 a=aa을 하여 a배열을 수정한다.

			int[] aa = new int[a.length*2];

			System.arraycopy(a, 0, aa, 0, a.length); 

			aa[a.length]=x;

			System.out.println("데이터 "+ x +"의 삽입이 완료되었습니다.");
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


			System.out.println("데이터 "+ x +"의 삽입이 완료되었습니다.");
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
			System.out.println("데이터 "+ x +"는 배열에 존재하지 않습니다.");
			}
		
		else{
			System.out.println("데이터 "+ x +"의 삭제가 완료되었습니다.");
			print();
		}

		
	}


	public void print () {

		int num=0;
		
		System.out.print("배열 원소 : ");
		for(int i=0 ; i<a.length ; i++) {

			if(a[i]!=0) {
				num++;
				System.out.print(a[i]+" ");
			}
		}
		
		
		System.out.print(", 크기: ");
		System.out.println(num);


	}
}






