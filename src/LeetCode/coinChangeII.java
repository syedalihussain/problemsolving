package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class coinChangeII {
	public static int change(int amount, int[] coins) {
		int[][] map = new int[coins.length + 1][amount];
		//	Fill in the first row and first column
		for (int i = 0; i < map.length; i++) {
			map[0][i] = 1;
		}
		findCombinations(amount, coins, map);
		return map[coins.length][amount];
		// return allCombinations.length();
	}

	public static void findCombinations(int amount, int[] coins, int[][] map) {
		int coin;
		for (int i = 1; i < map[0].length; i++) {
			coin = coins[i - 1];
			for (int j = 1; j < map.length; j++) {
				if ((j - coin) < 0)
					continue;
				map[i][j] = map[i-1][j] + map[i][j-coin];
			}
		}
	}

	public static void main(String[] args) {
		int[] coins = new int[]{1,2,5};
		System.out.println(change(5, coins));


	}
}
