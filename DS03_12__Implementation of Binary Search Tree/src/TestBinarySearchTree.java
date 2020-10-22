
public class TestBinarySearchTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.recu_insert(5);
		tree.recu_insert(10);
		tree.recu_insert(1);
		tree.recu_insert(3);
		tree.recu_insert(7);
		tree.recu_insert(13);
		tree.recu_insert(11);
		tree.recu_insert(15);
		tree.recu_insert(12);
		tree.inorder();
		System.out.println("-------------------------------");
		tree.delete(12);
		tree.delete(1);
		tree.delete(10);
		
		tree.inorder();
	
	

	}

}
