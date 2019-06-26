package OnlineTests.Quantifi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

		HashMap<Integer, Integer> countMap = new HashMap<>();
		int count, number;
		for (HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			count = entry.getValue();
			number = entry.getKey();
			countMap.put(count, number);
		}

		return countMap.get(nthMostRare);
	}

	public static void main(String[] args) {
		int x = nthMostRare(new int[]{5,4,3,2,1,5,4,3,2,5,4,3,5,4,5}, 2);
		System.out.println(x);
		List<Integer> list = new ArrayList<>();
	}

}
