package CtCI_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class permutationsWithDistinct_08_07 {
	ArrayList<String> getPerms(String str) {
		char[] charArray = str.toCharArray();
		ArrayList<String> permutations = new ArrayList<>();
		getPerms(permutations, charArray, 0);
		return permutations;
	}

	private void getPerms(ArrayList<String> permutations, char[] charArray, int startIndex) {
		if (startIndex == charArray.length) {
			permutations.add(new String(charArray));
			return;
		}

		for (int i = startIndex; i < charArray.length; i++) {
			
		}
	}

	private void swap(char[] chars, int l, int r) {
		char c = chars[l];
		chars[l] = chars[r];
		chars[r] = c;
	}

	public static void main(String[] args) {

	}
}
