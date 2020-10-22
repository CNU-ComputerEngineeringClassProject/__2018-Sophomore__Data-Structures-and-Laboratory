
public class LinkedList {

	Node startNode;

	public void insertlast(int x){
		
		Node p = startNode;

		if(startNode==null) {
			startNode = new Node(x);
		}
		else{
			for(;p.Next()!=null;p = p.Next()) {}
			p.setNext(new Node (x));
		}
	}



	public void insertfirst(int x) {

		if(startNode==null) {
			startNode = new Node(x);
		}
		else {
			Node p = new Node(x,startNode);
			startNode = p;
		}

	}



	public boolean contain (int x) {
		Node p=startNode;
		boolean check=false;

		for(; p.Next()!=null ; p=p.Next()) {
			if(p.Value()==x) {
			System.out.print(x+"이(가) 리스트 안에 존재합니다. ");
			check = true;
		break;
		}
			}
		
		if(p.Next()==null && p.Value()!=x) {
			System.out.print(x+"이(가) 리스트안에 존재하지않습니다. ");
			check = false;
		}
		
		System.out.println(check);
		
		return check;
		
	}

	public void print(){

		System.out.print("List :");

		for(Node p =startNode ; p!=null ; p=p.Next()) {
			System.out.print(" "+p.Value());
		}

		System.out.println();
	}
}
