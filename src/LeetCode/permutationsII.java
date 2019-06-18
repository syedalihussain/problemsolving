package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class permutationsII {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		HashMap<Integer, Integer> countMap = getHashMap(nums);
		System.out.println(countMap);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		permuteUnique(nums.length, list, result, countMap, 0);
		return result;
	}

	private static void permuteUnique(int len, List<Integer> list, List<List<Integer>> result, HashMap<Integer,Integer> countMap, int startIndex) {
		if (startIndex == len) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (Integer i : countMap.keySet()) {
			int count = countMap.get(i);
			if (count > 0) {
				countMap.put(i, count - 1);
				list.add(i);
				permuteUnique(len, list, result, countMap, startIndex + 1);
				list.remove(list.size() - 1);
				countMap.put(i, count);
			}
		}
	}

	public static HashMap<Integer, Integer> getHashMap(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i : nums) {
			hm.compute(i, (key, val) -> {
				if (val == null) {
					return 1;
				} else {
					return val + 1;
				}
			});
		}
		return hm;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 2};
		List<List<Integer>> permutations = permuteUnique(nums);
		System.out.println(permutations);
	}

}
