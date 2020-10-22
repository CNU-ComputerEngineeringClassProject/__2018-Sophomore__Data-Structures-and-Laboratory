import java.util.Random;

public class BinaryTree {
	private int[] tree;
	private int size;


	public BinaryTree(int a, int seed) {
		Random random = new Random();

		this.tree = new int[a];
		size = 0;
		random.setSeed(seed);
		for (int i = 0; i < a; i++) {
			tree[i] = random.nextInt(100);
			size++;
		}
	}

	public BinaryTree(int a) {
		this.tree = new int[a];
		size = 0;
		for (int i = 0; i < a; i++) {
			tree[i] = i;
			size++;
		}
	}

	public void levelOrder() {
		
		System.out.print("Level Order : ");
		for (int i = 0; i < size; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}

	public void preOrder(int i) {
		
		
		if( i < size/2 - 1) { //내부노드 -1
			System.out.print(tree[i] + " ");
			preOrder((i*2)+1); //왼쪽
			preOrder((i*2)+2); //오른쪽
			
		}
		else if(i == size/2 -1) {//내부노드 마지막
			System.out.print(tree[i] + " ");
			preOrder((i*2)+1);
			if(size%2 == 1) {
			preOrder((i*2)+2);
			}
		}
		else {
			System.out.print(tree[i] + " ");
		}	
	}

}
