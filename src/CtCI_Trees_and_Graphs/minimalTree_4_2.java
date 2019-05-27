package CtCI_Trees_and_Graphs;

import CtCILibrary.TreeNode;

import java.util.HashMap;

public class minimalTree_4_2 {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
		Character c = new Character('c');
		HashMap<String, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		char d = 'd';
		String str = Character.toString(d);
		hm.put("CV",4);
		System.out.println(str);
	}
}
