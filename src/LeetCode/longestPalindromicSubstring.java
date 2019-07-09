package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class longestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		//  "babad"
		//  Create a HashMap<Character, ArrayList<Integer>>
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> indexes;
		char[] charArray = s.toCharArray();
		int len = charArray.length;
		for (int i = 0; i < len; i++) {
			if (!map.containsKey(charArray[i])) {
				indexes = new ArrayList<>();
				indexes.add(i);
				map.put(charArray[i], indexes);
			} else {
				indexes = map.get(charArray[i]);
				indexes.add(i);
				map.put(charArray[i], indexes);
			}
		}
		String palindrome = "";
		int i = 0;
		while ((i + palindrome.length()) < len) {
			indexes = map.get(charArray[i]);
			for (int j = indexes.size()-1; j >= 0; j--) {
				int k = indexes.get(j);
				if ((k-i+1) <= palindrome.length()) {
					break;
				}
				if (checkPalindrome(charArray, i, k)) {
					palindrome = s.substring(i, k+1);
				}
			}
			i++;
		}

		return palindrome;
	}
	private static boolean checkPalindrome(char[] charArray, int s, int e) {
		for (int i = s; i <= s+(e-s)/2; i++) {
			if (charArray[i] != charArray[e-i+s])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String p1 = "aabcbc";
//		char[] charArray = p1.toCharArray();
//		System.out.println(checkPalindrome(charArray, 2, 6));
		String p2 = "bc";
//		System.out.println(checkPalindrome(p2.toCharArray(), 5, 9));
		System.out.println(p1.indexOf(p2, 2));
	}

}
