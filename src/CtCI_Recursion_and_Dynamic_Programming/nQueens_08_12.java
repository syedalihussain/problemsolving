package CtCI_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class nQueens_08_12 {
	public static int totalNQueens(int n) {
		int count = 0;
		List<Integer> results = new ArrayList<>();
		Integer[] cols = new Integer[n];
		placeQueens(results, 0, cols);
		return results.size();
	}

	public static void placeQueens(List<Integer> results, int row, Integer[] cols) {
		if (row == cols.length) {
			results.add(1);
		} else {
			for (int col = 0; col < cols.length; col++) {
				if (checkValid(cols, row, col)) {
					cols[row] = col;
					placeQueens(results, row + 1, cols);
				}
			}
		}
	}

	public static boolean checkValid(Integer[] cols, int row1, int col1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int col2 = cols[row2];

			if (col2 == col1)
				return false;

			int colDistance = Math.abs(col2-col1);
			int rowDistance = row1 - row2;
			if (colDistance == rowDistance)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(totalNQueens(8));
	}

}
