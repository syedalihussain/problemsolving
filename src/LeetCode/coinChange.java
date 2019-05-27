package LeetCode;

import java.util.*;

public class coinChange {

	public static int coinChange(int[] coins, int amount) {
		if (coins.length == 0)
			return -1;
		int len = coins.length;
		LinkedList<Integer> remaining = new LinkedList<>();
		LinkedList<List<Integer>> combinations = new LinkedList<>();
		List<Integer> combination = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();

		remaining.add(amount);
		combinations.add(combination);

		while (!remaining.isEmpty()) {
			int currentRemaining = remaining.pop();
			List<Integer> currentCombination = combinations.pop();
			if (currentRemaining == 0) {
				return currentCombination.size();
			}
			for (int c : coins) {
				int diff = (currentRemaining - c);
				if ((diff) == 0) {
					return currentCombination.size() + 1;
				}
				else if ((diff - c) > 0 && !hs.contains(diff)) {
					remaining.add(diff);
					List<Integer> newCombo = new ArrayList<>(currentCombination);
					newCombo.add(c);
					combinations.add(newCombo);
				} else {
					hs.add(diff);
				}
			}
		}

		return -1;
        /*
        Arrays.sort(coins);
        List<Integer> combinations = new ArrayList<>();
        if (findCoinChange(coins, amount, combinations, coins.length - 1))
            return combinations.size();
        return -1;
        */
	}
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		System.out.println(coinChange(coins, 100));
	}
}
