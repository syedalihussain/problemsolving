package LeetCode;

import java.util.*;

public class coinChange {

	public static int coinChange(int[] coins, int amount) {
		int[] checkArray = new int[amount + 1];
		int fillValue = amount + 1;
		for (int i = 1; i <= amount; i++) {
			checkArray[i] = fillValue;
		}

		for (int i = 1; i <= amount; i++) {
			for (int j : coins) {
				if ((i - j) < 0)
					continue;
				else {
					int currentCell = checkArray[i];
					int prevCell = checkArray[i - j];
					checkArray[i] = Math.min(prevCell + 1, currentCell);
				}
			}
		}

		return checkArray[amount] > amount ? -1 : checkArray[amount];
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		System.out.println(coinChange(coins, 11));
	}
}
