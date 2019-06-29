package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

	public static List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0)
			return new ArrayList<>();
		int ibeg = 0, iend = matrix.length - 1, jbeg = 0, jend = matrix[0].length - 1;
		List<Integer> results = new ArrayList<>();
		while (ibeg <= iend && jbeg <= jend) {
			for (int j = jbeg; j <= jend; j++) {
				results.add(matrix[ibeg][j]);
			}
			ibeg++;
			if (ibeg > iend)
				return results;
			for (int i = ibeg; i <= iend; i++) {
				results.add(matrix[i][jend]);
			}
			jend--;
			if (jend < jbeg)
				return results;
			for (int j = jend; j >= jbeg; j--) {
				results.add(matrix[iend][j]);
			}
			iend--;
			for (int i = iend; i >= ibeg; i--) {
				results.add(matrix[i][jbeg]);
			}
			jbeg++;
		}

		return results;
	}

	public static void main(String[] args) {
		int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] matrix3 = {{1}, {2}, {3}, {4}};
		int[][] matrix4 = {{1,2,3,4,5}};
		int[][] matrix5 = {{1,2}, {3,4}, {5,6}, {7,8}, {9,10}};
		int[][] matrix6 = {{1,2,3,4,5},{6,7,8,9,10}};
		int[][] matrix7 = {{1}};
		int[][] matrix8 = {{1,2}};
		int[][] matrix9 = {{1},{2}};
		int[][] matrix10 = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(new int[][]{}));
	}
}
