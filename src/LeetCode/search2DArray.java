package LeetCode;

public class search2DArray {
	//	Needs Completion
	public static boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length-1;
		int cols = matrix[0].length-1;
		if (target < matrix[0][0] || target > matrix[rows][cols]) {
			return false;
		}

		//  Get the index of the row
		int srow = 0, erow = rows;
		int mid = 0;
		while (srow != erow && matrix[erow][0] > target) {
			mid = srow + (erow - srow) / 2;
			if (matrix[mid][0] < target) {
				srow = mid;
			} else if (matrix[mid][0] > target) {
				erow = mid - 1;
			} else
				return true;
		}
		System.out.println(mid);
		//  Search in that row.




		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(matrix, 5));
	}
}
