package LeetCode;

public class uniquePathsWithObstacles {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int numOfRows = obstacleGrid.length;
		int numOfCols = obstacleGrid[0].length;

		if (numOfRows <= 1 || numOfCols <= 1)
			return numOfRows < numOfCols ? numOfRows : numOfCols;

		int[][] robotGrid = new int[numOfRows+1][numOfCols+1];
		robotGrid[numOfRows-1][numOfCols] = 1;

		for (int i = numOfRows-1; i >= 0; i--) {
			for (int j = numOfCols-1; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1) {
					continue;
				} else {
					robotGrid[i][j] = robotGrid[i+1][j] + robotGrid[i][j+1];
				}
			}
		}

		return robotGrid[0][0];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid =
				{
					{1},
					{0},
					{1}
						};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}

}
