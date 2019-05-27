package CtCI_Trees_and_Graphs;

import CtCILibrary.TreeNode;

public class checkBalanced_4_4 {
	public static boolean checkBalanced(TreeNode node) {
		if (node == null) return true;

		int left = node.left == null ? 0 : node.right.height();
		int right = node.right == null ? 0 : node.right.height();
		int diff = left - right;

		if (Math.abs(diff) > 1) {
			return false;
		} else {
			return checkBalanced(node.left) && checkBalanced(node.right);
		}
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println(checkBalanced(root));
	}
}
