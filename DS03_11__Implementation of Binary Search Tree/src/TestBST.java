
public class TestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree = new BST();
		tree.recu_insert(5);
		tree.recu_insert(10);
		tree.recu_insert(1);
		tree.recu_insert(3);
		tree.recu_insert(7);
		tree.inorder();
		
		System.out.println();
		
		tree.iter_insert(13);
		tree.iter_insert(11);
		tree.iter_insert(15);
		tree.iter_insert(12);
		tree.inorder();
		

	}

}
