package CtCI_Recursion_and_Dynamic_Programming;

public class magicIndex_08_03 {

	public static int magicIndex(int[] arr) {
		if (arr == null || arr.length == 0)
			return -1;
		return findMagicIndex(arr, 0, arr.length-1);
	}

	private static int findMagicIndex(int[] arr, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = start + (end - start) / 2;

		if (arr[mid] == mid)
			return mid;

		int leftIndex = Math.min(mid - 1, arr[mid]);
		int leftResult = findMagicIndex(arr, start, leftIndex);
		if (leftResult >= 0)
			return leftResult;

		int rightIndex = Math.max(mid + 1, arr[mid]);
		int rightResult = findMagicIndex(arr, rightIndex, end);

		return rightResult;
	}
	public static void main(String[] args) {





	}
}
