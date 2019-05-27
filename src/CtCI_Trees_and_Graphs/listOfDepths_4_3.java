package CtCI_Trees_and_Graphs;

import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class listOfDepths_4_3 {
	public static ArrayList<LinkedList<TreeNode>> getListOfDepths(TreeNode node) {
		if (node == null) return null;
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		HashSet<TreeNode> hs = new HashSet<>();
		current.add(node);
		while (!current.isEmpty()) {
			res.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				if (parent.left!=null) {
					current.add(parent.left);
				}
				if (parent.right!=null) {
					current.add(parent.right);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);

		ArrayList<LinkedList<TreeNode>> lists = getListOfDepths(root);
		LinkedList<TreeNode> list = lists.get(3);
		for (TreeNode tn : list) {
			System.out.print(tn.data + ", ");
		}
	}
}
