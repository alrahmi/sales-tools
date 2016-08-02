package test.part1;


public class AppMain {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.setLeft(new Node(10));
		root.setRight(new Node(15));
		root.getLeft().setLeft(new Node(20));
		root.getLeft().setRight(new Node(25));
		root.getLeft().getLeft().setLeft(new Node(30));
		root.getLeft().getRight().setLeft(new Node(35));
		root.getLeft().getRight().getLeft().setLeft(new Node(40));
		root.getLeft().getRight().getLeft().getLeft().setRight(new Node(45));
		root.getLeft().getRight().getLeft().getLeft().getRight().setLeft(new Node(50));
		HeightOfTree heightOfTree = new HeightOfTree();
		System.out.println("The theiht of tree is -:" + heightOfTree.maxHeightOfTree(root));
	}
}
