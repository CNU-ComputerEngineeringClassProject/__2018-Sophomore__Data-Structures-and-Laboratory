import java.util.LinkedList;

public class TestOrderTree {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrderedTree orderedtree = new OrderedTree();

		OrderedTree treeA, treeB, treeD, treeE, treeG;
		
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeH = new OrderedTree("H");
		OrderedTree treeI = new OrderedTree("I");
		OrderedTree treeJ = new OrderedTree("J");
		OrderedTree treeK = new OrderedTree("K");
		OrderedTree treeL = new OrderedTree("L");
		OrderedTree treeM = new OrderedTree("M");

		LinkedList subtreesOfE = new LinkedList();
		subtreesOfE.add(treeH);
		subtreesOfE.add(treeI);

		treeE = new OrderedTree("E", subtreesOfE);

		LinkedList subtreesOfB = new LinkedList();
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);

		treeB = new OrderedTree("B", subtreesOfB);

		
		
		LinkedList subtreesOfG = new LinkedList();

		subtreesOfG.add(treeJ);
		subtreesOfG.add(treeK);
		subtreesOfG.add(treeL);
		subtreesOfG.add(treeM);

		treeG = new OrderedTree("G", subtreesOfG);

		LinkedList subtreesOfD = new LinkedList();

		subtreesOfD.add(treeG);

		treeD = new OrderedTree("D", subtreesOfD);

		LinkedList subtreesOfA = new LinkedList();

		subtreesOfA.add(treeB);		
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);

		
		treeA = new OrderedTree("A", subtreesOfA);

		orderedtree.levelOrder(treeA);

	}

}
