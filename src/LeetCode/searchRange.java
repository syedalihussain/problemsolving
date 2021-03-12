package LeetCode;

import java.util.List;

public class searchRange {
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int mid = len / 2;
        int f = binarySearch(nums, 0, len-1, target, -1);
        int e = binarySearch(nums, 0, len-1, target, 1);

        return new int[] {f, e};
        //  4, 5

    }

    public static int binarySearch(int[] nums, int start, int end, int target, int dir) {
        if (start >= end) {
            return nums[start] == target ? start : -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            if (dir == -1) {
                int leftHalf = binarySearch(nums, start, mid, target, dir);
                return leftHalf != -1 ? leftHalf : mid;
            } else {
                int rightHalf = binarySearch(nums, mid+1, end, target, dir);
                return rightHalf != -1 ? rightHalf : mid;
            }
        } else if (nums[mid] > target) {
            return binarySearch(nums, start, mid, target, dir);
        }
        return binarySearch(nums, mid+1, end, target, dir);
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8,10};
        int target = 8;

        System.out.println(searchRange(arr, target)[0]);
        System.out.println(searchRange(arr, target)[1]);
        System.out.println("Hello");
    }
}
