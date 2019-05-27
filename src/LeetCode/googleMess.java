package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class googleMess {

	public static void getAverage(List<String> lines) {
		HashMap<String, Stack<Long>> hm = new HashMap<>();
		for (int i = 0; i < lines.size(); i++) {
			String[] lineArray = lines.get(i).split(" ");
			String apiName = lineArray[0];
			String apiStatus = lineArray[1];
			Long apiTimestamp = Long.parseLong(lineArray[2]);
			if (hm.containsKey(apiName)) {
				Stack<Long> differences = hm.get(apiName);
				if (apiStatus.equals("start")) {
					differences.push(apiTimestamp);
				}
				else {
					Long beg = differences.pop();
					Long diff = apiTimestamp - beg;
					differences.push(diff);
				}
				hm.put(apiName, differences);
			} else {
				Stack<Long> newStack = new Stack<>();
				newStack.push(apiTimestamp);
				hm.put(apiName, newStack);
			}
		}
		List<List<String>> arrayList = new ArrayList(hm.values());
		System.out.println(arrayList);
		for (String str : hm.keySet()) {
			Stack<Long> stack = hm.get(str);
			int count = 0;
			int sumOfDifferences = 0;
			while (stack.size() > 0) {
				sumOfDifferences += stack.pop();
				count++;
			}
			int average = sumOfDifferences / count;
			System.out.println(str + " : average = " + average);
		}
	}

	public static void main(String[] args) {
		List<String> lines = new ArrayList<>();

		lines.add("get_foo start 2222222100");
		lines.add("get_foo end 2222222150");
		lines.add("get_bar start 2222222200");
		lines.add("get_foo start 2222222220");
		lines.add("get_bar end 2222222230");
		lines.add("get_foo end 2222222250");
		getAverage(lines);
	}
}
