
import java.util.*;

public class OrderedTree {
	private Object root;
	private List subtrees;
	private int size;

	public OrderedTree() {} //�� Ʈ��
	public OrderedTree(Object root) { //�̱�
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
		
		//ť�� �ʱ�ȭ
		Queue queue = new SLinkedQueue();
		//��Ʈ�� ť�� ����
		queue.add(tree);
		//ť�� ������ �ɶ����� �ݺ�
		System.out.print("Level Order : ");	
		while(queue.size() != 0) {
			//ť���� ù��° ��� x���� , x�� ���
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



