package OnlineTests;

import java.util.ArrayList;
import java.util.List;

public class longestValidPassword {

	public static int findPassword(String s) {
		if (s.length() == 0) {
			return 0;
		}
		char[] charArray = s.toCharArray();
		boolean upperFound = false;
		int head = 0;
		int len = s.length();
		int maxLength = -1;
		int currentLength;
		while (head < len) {
			currentLength = 0;
			while (head < len && charArray[head] >= '0' && charArray[head] <= '9') {
				head++;
			}
			while (head < len && (charArray[head] < '0' || charArray[head] > '9')) {
				if (charArray[head] >= 'A' && charArray[head] <= 'Z') {
					upperFound = true;
				}
				currentLength++;
				head++;
			}
			if (currentLength > maxLength && upperFound) {
				maxLength = currentLength;
				upperFound = false;
			}
			head++;
		}
		return maxLength;
	}


	public static void main(String[] args) {
		System.out.println(findPassword("a0Ba"));
		List<Integer> list = new ArrayList<>();
	}
}
