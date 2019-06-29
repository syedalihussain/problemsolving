package O.Q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
		int mask = 9;
		System.out.println(mask);
		mask = mask ^ (1);
		System.out.println(mask);
	}

}
