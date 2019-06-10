package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class combinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0)
			return null;
		Arrays.sort(candidates);
		List<List<Integer>> combinations = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		int startIndex = 0;
		findCombinations(candidates, target, combinations, combination, startIndex);
		return combinations;
	}

	public static void findCombinations(int[] candidates, int target, List<List<Integer>> combinations, List<Integer> combination, int startIndex) {
		if (target == 0) {
			List<Integer> found = new ArrayList<>(combination);
			combinations.add(found);
			return;
		} else if ( target < 0)
			return;
		int len = candidates.length;
		for (int i = startIndex; i < len; i++) {
			int num = candidates[i];
			int newTarget = target - num;
			combination.add(num);
			findCombinations(candidates, newTarget, combinations, combination, i);
			combination.remove(combination.size() - 1);
		}
	}
	enum Rank {
		One, Two, Three;
		public int getValue() {
			if (this == Rank.One) {
				return 1;
			}
			return 0;
		}
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(9);
		queue.add(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(Rank.One.getValue());

	}

}
