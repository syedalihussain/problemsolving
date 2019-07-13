package LeetCode;

public class spiralOrderII {
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int square = n*n;
		int row = 0;
		int col = 0;
		int num = 1;
		n--;
		int t = n;
		int dir = 1;
		int i = 1;
		while (i <= square) {
			matrix[row][col] = i;
			if (dir == 1) {
				if (t > 1) {
					col++;
					t--;
				} else {
					col++;
					dir++;
					t = n;
				}
			} else if (dir == 2) {
				if (t > 1) {
					row++;
					t--;
				} else {
					row++;
					dir++;
					t = n;
				}
			} else if (dir == 3) {
				if (t > 1) {
					col--;
					t--;
				} else {
					col--;
					dir++;
					t = n;
				}
			} else if (dir == 4) {
				if (t > 1) {
					row--;
					t--;
				} else {
					n--;
					t = n;
					dir = 1;
					col++;
				}
			}
			i++;
		}

		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = generateMatrix(3);
	}
}
