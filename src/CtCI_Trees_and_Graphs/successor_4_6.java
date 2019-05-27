package CtCI_Trees_and_Graphs;

import CtCILibrary.TreeNode;

public class successor_4_6 {
	public static TreeNode successor(TreeNode n) {
		if (n == null) return null;

		if (n.right != null) {
			return getLeftMostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode p = q.parent;
			while (p!=null && p.left!=q) {
				q = p;
				p = q.parent;
			}
			return p;
		}
	}

	public static TreeNode getLeftMostChild(TreeNode n) {
		if (n == null) return null;
		while (n.left!=null) {
			n = n.left;
		}
		return n;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode scrutiny = root.left.right.right;
		System.out.println("Node under scrutiny is: " + scrutiny.data);
		TreeNode succ = successor(scrutiny);
		System.out.println("It's successor is: " + succ.data);
	}
}
