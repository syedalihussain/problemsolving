package Pramp;

public class shortestUniqueSubstring {
	static String getShortestUniqueSubstring(char[] arr, String str) {

		int head = 0, tail = 0;
		int counter = 0;
		int lowestLength = Integer.MAX_VALUE;

		char[] strArray = str.toCharArray();
		int[] uniqueChars = new int[128];
		int[] currentStatus = new int[128];

		for (char c : arr) {
			uniqueChars[c]++;
		}
		String res = "";

		//	arr = ['x','y','z'], str = "ax byyz yzyx"
		//						 str = "yx"
		for (head = 0; head < str.length(); head++) {

			char headChar = strArray[head];

			if (uniqueChars[headChar] == 1 && currentStatus[headChar] == 0) {
				counter++;
			}

			currentStatus[headChar]++;

			while (counter == arr.length) {
				if ((head - tail + 1) == arr.length) {
					return str.substring(tail, head + 1);
				}

				if ((head - tail + 1) < lowestLength) {
					res = str.substring(tail, head + 1);
				}

				char temp = strArray[tail++];
				if (uniqueChars[temp] == 1 && currentStatus[temp] == 1) {
					counter--;
				}
				currentStatus[temp]--;
			}
		}

		return res;
	}

	public static void main(String[] args) {

	}
}
