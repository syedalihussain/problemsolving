package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class coinChangeII {
	public static int change(int amount, int[] coins) {
		int[][] map = new int[coins.length + 1][amount + 1];
		//	Fill in the first row and first column
		for (int i = 0; i <= coins.length; i++) {
			map[i][0] = 1;
		}
		findCombinations(amount, coins, map);
		return map[coins.length][amount];
		// return allCombinations.length();
	}

	public static void findCombinations(int amount, int[] coins, int[][] map) {
		int coin;
		for (int i = 1; i < map.length; i++) {
			coin = coins[i - 1];
			for (int j = 1; j < map[0].length; j++) {
				if ((j - coin) < 0)
					map[i][j] = map[i-1][j];
				else
					map[i][j] = map[i-1][j] + map[i][j-coin];
			}
		}
	}

	public static void main(String[] args) {
		//	5000
		//	[11,24,37,50,63,76,89,102]
		int[] coins = new int[]{11,24,37,50,63,76,89,102};
		System.out.println(change(5000, coins));

	}
}
