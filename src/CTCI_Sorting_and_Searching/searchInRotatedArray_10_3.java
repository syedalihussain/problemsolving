package CTCI_Sorting_and_Searching;

public class searchInRotatedArray_10_3 {

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		return searchInRotated(nums, left, right, target);
	}

	private static int searchInRotated(int[] nums, int left, int right, int target) {
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (right < left) {
			return -1;
		}

		if (nums[left] < nums[mid]) {   //  Left side is sorted
			if (nums[mid] > target && target > nums[left]) {
				return searchInRotated(nums, left, mid - 1, target);
			} else {
				return searchInRotated(nums, mid + 1, right, target);
			}
		} else if (nums[mid] < target && target < nums[right]) {    //  Right side is sorted
			if (nums[mid] < target) {
				return searchInRotated(nums, mid + 1, right, target);
			} else {
				return searchInRotated(nums, left, mid - 1, target);
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int index = search(nums, 0);
	}
}
