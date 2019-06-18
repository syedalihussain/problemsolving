package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class permutations {
	public static List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();
		permute(nums, list, res, hs, 0);
		return res;
	}
	public static void permute(int[] nums, List<Integer> list, List<List<Integer>> res, HashSet<Integer> hs, int startIndex) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		int current;
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i]))
				continue;
			hs.add(nums[i]);
			current = nums[i];
			list.add(current);
			permute(nums, list, res, hs, i + 1);
			list.remove(list.size() - 1);
			hs.remove(nums[i]);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3};
		List<List<Integer>> result = permute(nums);
		System.out.println(result);
	}

}
