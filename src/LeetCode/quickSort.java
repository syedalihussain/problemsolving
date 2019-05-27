package LeetCode;

public class quickSort {
	public static int[] sortArray(int[] nums) {
		quicksort(nums, 0, nums.length-1);
		return nums;
	}

	public static void quicksort(int[] array, int left, int right) {
		if (left >= right)
			return;

		int pivot = array[left + (right-left)/2];
		int start = left;
		int end = right;

		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		quicksort(array, start, left-1);
		quicksort(array, left, end);
	}

	public static void main(String[] args) {
//		int[] array = {5,1,1,2,0,0};
		int[] array = {5,4,1,2,6};
		sortArray(array);
		for(int i : array) {
			System.out.println(i);
		}
	}
}
