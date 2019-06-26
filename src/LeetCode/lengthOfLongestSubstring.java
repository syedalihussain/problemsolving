package LeetCode;

import java.util.*;

public class lengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i);
			map.put(s.charAt(j), j);
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "bbbbbb";
		System.out.println(lengthOfLongestSubstring(str));
	}
}
