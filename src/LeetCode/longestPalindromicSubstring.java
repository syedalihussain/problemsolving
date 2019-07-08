package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class longestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		//  "babad"
		//  Create a HashMap<Character, ArrayList<Integer>>
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> indexes;
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				indexes = new ArrayList<>();
				indexes.add(i);
				map.put(s.charAt(i), indexes);
			} else {
				indexes = map.get(s.charAt(i));
				indexes.add(i);
				map.put(s.charAt(i), indexes);
			}
		}
		String palindrome = "";
		char[] charArray = s.toCharArray();
		int len = charArray.length;
		int i = 0;
		while ((i + palindrome.length()) < len) {
			indexes = map.get(charArray[i]);
			for (int j = indexes.size()-1; j >= 0; j--) {
				int k = indexes.get(j);
				if ((k-i+1) < palindrome.length()) {
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
		for (int i = s; i < (e-s)/2; i++) {
			if (charArray[i] != charArray[e-s-i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
	}

}
