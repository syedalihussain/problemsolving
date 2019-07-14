package LeetCode;

import java.util.HashMap;

public class longestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] charArray = s.toCharArray();
		int j = 0;
		int maxLength = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = charArray[i];
			if (map.containsKey(c)) {
				j = Math.max(j, map.get(c) + 1);
			}
			maxLength = Math.max(maxLength, (i-j+1));
			map.put(c, i);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abba"));
	}
}
