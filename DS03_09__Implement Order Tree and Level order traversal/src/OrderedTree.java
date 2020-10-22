
import java.util.*;

public class OrderedTree {
	private Object root;
	private List subtrees;
	private int size;

	public OrderedTree() {} //빈 트리
	public OrderedTree(Object root) { //싱글
		this.root=root;
		subtrees = new LinkedList();
		size = 1;	
	}

	public OrderedTree(Object root, List trees) { 
		this(root);
		for(Iterator it = trees.iterator(); it.hasNext();){
			Object objects = it.next();
			if(objects instanceof OrderedTree){ 
				OrderedTree tree = (OrderedTree) objects;
				subtrees.add(tree);
				size += tree.size();
			}
		}
	}

	public int size() {
		return size;
	}

	public void levelOrder(OrderedTree tree) {
		
		//큐를 초기화
		Queue queue = new SLinkedQueue();
		//루트를 큐에 삽입
		queue.add(tree);
		//큐가 공백이 될때까지 반복
		System.out.print("Level Order : ");	
		while(queue.size() != 0) {
			//큐에서 첫번째 노드 x삭제 , x를 출력
			OrderedTree treeQremove = (OrderedTree)queue.remove();
			System.out.print(treeQremove.root+" ");
			for(Iterator it=treeQremove.subtrees.iterator();it.hasNext();) {
				Object object = it.next();
				if(object instanceof OrderedTree){
					OrderedTree trees = (OrderedTree) object;
					queue.add(trees);
				}



			}


		}

	}

	   
	   
}



