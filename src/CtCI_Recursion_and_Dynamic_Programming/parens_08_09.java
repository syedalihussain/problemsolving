package CtCI_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class parens_08_09 {

	public static List<String> generateParens(int n) {
		char[] charArray = new char[n*2];
		List<String> combinations = new ArrayList<>();
		generateParens(combinations, charArray, n, n, 0);
		return combinations;
	}

	private static void generateParens(List<String> combinations, char[] charArray, int left, int right, int i) {
		if (left < 0 || left > right || right < 0)
			return;

		if (left == 0 && right == 0) {
			combinations.add(new String(charArray));
			return;
		}

		charArray[i] = '(';
		generateParens(combinations, charArray, left - 1, right, i + 1);

		charArray[i] = ')';
		generateParens(combinations, charArray, left, right - 1, i + 1);


	}

	public static void main(String[] args) {

		System.out.println(generateParens(3));
	}
}
