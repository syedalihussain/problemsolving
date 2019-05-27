package Pramp;

import java.util.*;

public class wordEngineCount {
	static String[][] wordCountEngine(String document) {

//		Map<String, Integer> map = wordCounts(document);
		char[] charArray = document.toLowerCase().toCharArray();
		int head = 0, tail = 0;
		HashMap<String, Integer> hm = new HashMap<>();
		int longestCount = 0;
		while (head < document.length()) {
			while (charArray[head] == ' ') {
				head++;
			}
			StringBuilder sb = new StringBuilder();
			while (head < document.length() && charArray[head] != ' ') {
				if ((charArray[head]) >= 'a' && (charArray[head]) <= 'z')
					sb.append(charArray[head]);
				head++;
			}
			System.out.println("head " + head + " value : " + sb.toString());
			String substr = sb.toString();
			if (!hm.containsKey(substr)) {
				hm.put(substr, 1);
				longestCount++;
			} else {
				int value = hm.get(substr);
				value++;
				hm.put(substr, value);
			}
		}
		List<List<String>> counterList = new ArrayList<>();
		for (int i = 0; i < longestCount; i++) {
			counterList.add(null);
		}
		List<String> wordCounterList;

		for (String word : hm.keySet()) {
			int counter = hm.get(word);
			wordCounterList = counterList.get(counter);

			if (wordCounterList == null) {
				wordCounterList = new ArrayList<>();
			}

			wordCounterList.add(word);
			counterList.remove(counter);
			counterList.add(counter, wordCounterList);
		}

		String[][] result = new String[longestCount][2];
		int index = 0;
		for (int i = counterList.size() - 1; i >= 0; i--) {
			wordCounterList = counterList.get(i);
			if (wordCounterList == null)
				continue;
			String occurrenceValue = Integer.toString(i);
			for (int j = 0; j < wordCounterList.size(); j++) {
				result[index][0] = wordCounterList.get(j);
				result[index][1] = occurrenceValue;
				index++;
			}
		}

		return result;
	}


	public static void main(String[] args) {
		String document = "Practice makes perfect. you'll   only get Perfect by practice. just practice!";
		String[][] results = wordCountEngine(document);
	}
}
