package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class allAnagramsInAString {
	public static List<Integer> findAnagrams(String s, String p) {
		if (s.length() < p.length()) {
			return new ArrayList<Integer>();
		}
		int head = 0, tail = 0;
		char[] pArray = p.toCharArray();
		char[] sArray = s.toCharArray();
		int[] targetChars = new int[128];
		int[] currentStatus = new int[128];
		int counter = 0;
		char headChar;
		char tailChar;

		List<Integer> res = new ArrayList<>();
		HashMap<Character, Integer> hm = new HashMap<>();
		for (char c : pArray) {
			if (!hm.containsKey(c)) {
				hm.put(c, 1);
			} else {
				int t = hm.get(c) + 1;
				hm.put(c, t);
			}
			targetChars[c] = 1;
			currentStatus[c]++;
			counter++;
		}
		//  Move for the length of p
		while (head < p.length() - 1) {
			headChar = sArray[head];
			if (targetChars[headChar] == 1 && currentStatus[headChar] > 0) {
				currentStatus[headChar]--;
				counter--;
			}
			head++;
		}

		while (head < s.length()) {

			headChar = sArray[head];
			tailChar = sArray[tail];
			//  "cbaebabacd"
			//  "abc"
			if (targetChars[headChar] == 1) {
				if (currentStatus[headChar] <= hm.get(headChar) && currentStatus[headChar] > 0)
					counter--;
				currentStatus[headChar]--;
			}

			if (counter == 0) {
				res.add(tail);
			}

			if (targetChars[tailChar] == 1) {
				currentStatus[tailChar]++;
				if (currentStatus[tailChar] <= hm.get(tailChar) && currentStatus[tailChar] > 0)
					counter++;
			}

			tail++;
			head++;

		}

		return res;

	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> indeces = findAnagrams(s, p);
		System.out.println(indeces);

	}
}
