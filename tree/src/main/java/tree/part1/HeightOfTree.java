package tree.part1;

public class HeightOfTree {
	public int maxHeightOfTree(Node node) {
		if (node == null) {
			return 0;
		}
		return (1 + Math.max(maxHeightOfTree(node.getLeft()), maxHeightOfTree(node.getRight())));
	}
}
