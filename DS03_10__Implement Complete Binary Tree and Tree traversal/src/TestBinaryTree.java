
public class TestBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("test1");
		BinaryTree test1 = new BinaryTree(9);
		
		test1.levelOrder();
		System.out.print("Preorder : ");
		test1.preOrder(0);
		
		
		System.out.println();
		System.out.println();
		System.out.println("test2");
		
		BinaryTree test2 = new BinaryTree(9,10);
		
		test2.levelOrder();
		System.out.print("Preorder : ");
		test2.preOrder(0);
	
	}

}
