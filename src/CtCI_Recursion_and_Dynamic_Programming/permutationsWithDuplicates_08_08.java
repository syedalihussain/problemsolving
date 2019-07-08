package CtCI_Recursion_and_Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class permutationsWithDuplicates_08_08 {

	public static ArrayList<String> getPerms(String s) {
		char[] charArray = s.toCharArray();
		HashSet<String> set = new HashSet<>();
		ArrayList<String> permutations = new ArrayList<>();
		getPerms(permutations, set, charArray, 0);
		return permutations;
	}

	private static void getPerms(ArrayList<String> permutations, HashSet<String> set, char[] charArray, int startIndex) {
		if (startIndex == charArray.length) {
			String s = new String(charArray);
			if (!set.contains(s)) {
				set.add(s);
				permutations.add(s);
			}
			return;
		}

		for (int i = startIndex; i < charArray.length; i++) {
			swap(charArray, startIndex, i);
			getPerms(permutations, set, charArray, startIndex+1);
			swap(charArray, startIndex, i);
		}
	}

	private static void swap(char[] chars, int l, int r) {
		char c = chars[l];
		chars[l] = chars[r];
		chars[r] = c;
	}

	public static void main(String[] args) {
		System.out.println(getPerms("aaaa"));
		String pal = "";
		System.out.println(pal.length());
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list.get(1));
	}
}
