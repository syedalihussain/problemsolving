package CtCI_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class permutationsWithDistinct_08_07 {
	ArrayList<String> getPerms(String str) {
		char[] charArray = str.toCharArray();
		ArrayList<String> result = new ArrayList<>();
		getPerms(charArray, result);
		return result;
	}

	private void getPerms(char[] charArray, ArrayList<String> result) {
	}

	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		res.add(list1);
		List<Integer> list2 = new ArrayList<>(list1);
		list2.add(2);
		res.add(list2);
//		System.out.println(res);
		System.out.println(list2);
		list2.remove(list2.size() - 1);
		System.out.println(list2);

	}
}
