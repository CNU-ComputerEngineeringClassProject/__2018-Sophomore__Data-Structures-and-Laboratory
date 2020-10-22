import java.util.Stack;

public class BST {

	private Comparable key;
	private BST left, right;
	private int size;

	public BST(){
		this.size = 0;
		left = null;
		right =null;
		key = null;
	}

	public BST(int key){
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
					BST Rbst = new BST(key);
					this.right = Rbst;
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
					BST Lbst = new BST(key);
					this.left = Lbst;
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
			BST tree = (BST)this;
			BST treeSize = null;
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
						BST Rbst = new BST(key);
						tree.right = Rbst;
						while(!stack.empty()) {
							treeSize=(BST) stack.pop();
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
						BST Lbst = new BST(key);
						tree.left = Lbst;
						while(!stack.empty()) {
							treeSize=(BST) stack.pop();
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
			System.out.println("빈트리 입니다.");
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



}
