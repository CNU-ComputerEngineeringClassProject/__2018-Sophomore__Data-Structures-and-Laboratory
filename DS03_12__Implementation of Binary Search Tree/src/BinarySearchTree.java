import java.util.Stack;


public class BinarySearchTree {
	private Comparable key;
	private BinarySearchTree left, right;
	private int size;

	public BinarySearchTree(){
		this.size = 0;
		left = null;
		right =null;
		key = null;
	}

	public BinarySearchTree(int key){
		this.size = 1;
		left = null;
		right =null;
		this.key = new Node(key);
	}




	private class Node implements Comparable{

		public int key;

		public Node(int key){
			this.key = key;
		}


		@Override
		public int compareTo(Object other) {
			if(this.key >(int)other) {
				return 1;
			}else if(this.key == (int)other) {
				return 0;
			}else {
				return -1;
			}
		}
	}



	public int treesize() {
		return size;
	}
	public boolean recu_insert (int key) {

		if(size==0) {
			this.key = new Node(key);
			size++;
			return true;
		}
		else {
			if(this.key.compareTo(key) == 0) {
				return false;

			}else if(this.key.compareTo(key) < 0) {
				if(this.right != null){
					if(this.right.recu_insert(key) == true) {
						if(this.right.size > 1) {
							size++;}
						return true;
					}
					return false;
				}
				else {
					BinarySearchTree RBinarySearchTree = new BinarySearchTree(key);
					this.right = RBinarySearchTree;
					this.right.size = 1; 
					size++;
					return true;

				}
			} else if(this.key.compareTo(key) >0) {
				if(this.left != null){

					if(this.left.recu_insert(key) == true) {
						if(this.left .size > 1) {
							size++;}
						return true;
					}
					return false;

				}
				else {
					BinarySearchTree LBinarySearchTree = new BinarySearchTree(key);
					this.left = LBinarySearchTree;
					left.size = 1; 
					size++;
					return true;

				}
			}
			else {return false;}
		}

	}

	public boolean iter_insert (int key) {

		Stack stack = new Stack();

		if(size == 0) {
			this.key = new Node(key);
			size++;
			return true;
		}
		else {
			BinarySearchTree tree = (BinarySearchTree)this;
			BinarySearchTree treeSize = null;
			while(tree.key.compareTo(key) != 0) {

				stack.push(tree);

				if(tree.key.compareTo(key) == 0) {
					return false;
				}

				else if(tree.key.compareTo(key) < 0) {
					if(tree.right != null){
						tree = tree.right;
					}
					else {
						BinarySearchTree RBinarySearchTree = new BinarySearchTree(key);
						tree.right = RBinarySearchTree;
						while(!stack.empty()) {
							treeSize=(BinarySearchTree) stack.pop();
							treeSize.size++;
						}

						return true;

					}

				}
				else if(tree.key.compareTo(key) >0) {
					if(tree.left != null){
						tree = tree.left;
					}
					else {
						BinarySearchTree LBinarySearchTree = new BinarySearchTree(key);
						tree.left = LBinarySearchTree;
						while(!stack.empty()) {
							treeSize=(BinarySearchTree) stack.pop();
							treeSize.size++;
						}

						return true;

					}
				}
				else {return false;}

			}
			return false;
		}

	}
	public void inorder() {
		if(size == 0) {	
			return ;
		}
		Node p = (Node) this.key;
		if(this.left != null) {
			this.left.inorder();
		}
		System.out.println("Visited : "+ p.key +", TreeSize : "+this.size);
		if(this.right != null) {
			this.right.inorder();
		}
	}

	public boolean delete(int key) {


		if(size==0) {
			return false;
		}
		else {

			
			if(this.key.compareTo(key) == 0) {
				//case 1
				if(this.size == 1) {
					this.key = null;
					this.size--;
					return true;
				}

				//case 2
				else if(this.right!=null && this.left==null) {

					this.key = this.right.key;
					this.left = this.right.left;
					this.right = this.right.right;
					this.size--;

					return true;
				}
				else if(this.right==null && this.left!=null) {

					this.key = this.left.key; 
					this.right = this.left.right;
					this.left = this.left.left;
					this.size--;


					return true;

				}
				//case 3
				else if(this.right!=null && this.left!=null) {

					this.key = delete_minimum(this);

					Node p = (Node) this.key;

					System.out.println("* Alternative Node : "+p.key);
					this.size--;

					return true;
				}


			}

			else if(this.key.compareTo(key) < 0) {
				if(this.right != null){
					if(this.right.delete(key) == true) {
						if(this.size-this.right.size !=1) {
							size--;}
						return true;
					}
					return false;
				}

			} else if(this.key.compareTo(key) >0) {
				if(this.left != null){

					if(this.left.delete(key) == true) {
						if(this.size-this.left .size != 1) {
							size--;}
						return true;
					}
					return false;

				}

			}
			else {return false;}
		}
		return false;


	}

	public Comparable delete_minimum(BinarySearchTree T) {


		BinarySearchTree treeSize = null;
		Comparable minimum;
		Stack stack = new Stack();

		T = T.right;
		stack.push(T);

		while(T.left != null) {

			T = T.left;
			stack.push(T);

		}

		if(T.right != null) {
			while(!stack.empty()) {
				treeSize = (BinarySearchTree)stack.pop();
				treeSize.size--;
			}
			minimum = T.key;
			T.key = T.right.key;
			T.left = T.right.left;
			T.right = T.right.right;
			
		}

		else {

			while(!stack.empty()) {
				treeSize = (BinarySearchTree)stack.pop();
				treeSize.size--;
			}
			minimum = T.key;
			T = null;
		}



		return minimum;
	}


}
