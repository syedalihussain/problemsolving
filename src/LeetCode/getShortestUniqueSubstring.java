package LeetCode;

import java.util.HashMap;

public class getShortestUniqueSubstring {
	static String getShortestUniqueSubstring(char[] arr, String str) {
		// your code goes here
		String res = "";
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for(char c : arr) {
			hm.put(c, 0);
		}

		int tail = 0;
		int head = 0;
		int uniqueCounter = 0;
		char[] strArray = str.toCharArray();

		while (tail < str.length()) {
			char c = strArray[tail];

			//  The current letter is not what we need
			if (!hm.containsKey(c))
				continue;

			int tailCount = hm.get(c);
			if (tailCount == 0) {
				uniqueCounter++;
			}
			hm.put(c, tailCount + 1);

			while (uniqueCounter == arr.length) {
				int tempLength = tail - head + 1;

				if (tempLength == arr.length) {
					return str.substring(head, tail + 1);
				}

				if (res.equals("") || tempLength < res.length()) {
					res = str.substring(head, tail + 1);
				}

				char headChar = strArray[head];

				if (hm.containsKey(headChar)) {
					int headCount = hm.get(headChar) - 1;
					if (headCount == 0) {
						uniqueCounter--;
					}
					hm.put(headChar, headCount);
				}
				head++;
			}
			tail++;
		}

		return res;
	}

	public static void main(String[] args) {
		char[] arr = {'x', 'y', 'z'};
		String str = new String("xyyzyzyx");
		String subString = getShortestUniqueSubstring(arr, str);
		System.out.println(subString);
	}
}
