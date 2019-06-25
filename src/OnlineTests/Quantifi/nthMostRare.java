package OnlineTests.Quantifi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class nthMostRare {

	public static int nthMostRare(int[] elements, int num) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < elements.length; i++) {
			hashMap.put(elements[i], hashMap.getOrDefault(elements[i], 0) + 1);
		}
		Integer[] array = new Integer[hashMap.size()];
		hashMap.values().toArray(array);
		Arrays.sort(array);
		int nthMostRare = array[num - 1];
		HashMap<Integer, LinkedList<Integer>> countMap = new HashMap<>();
		int number, count;
		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			number = entry.getKey();
			count = entry.getValue();
			if (!countMap.containsKey(count)) {
				LinkedList<Integer> list1 = new LinkedList<>();
				list1.add(number);
				countMap.put(count, list1);
			} else {
				countMap.get(count).add(number);
			}
		}

		return countMap.get(num).pop();
	}

	public static void main(String[] args) {
		int x = nthMostRare(new int[]{5,4,3,2,1,5,4,3,2,5,4,3,5,4,5}, 1);
		System.out.println(x);
	}

}
