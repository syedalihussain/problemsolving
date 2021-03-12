package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class canPartitionKSubsets {
    static int len;
    static Set<Integer> set;
    static Set<Integer> visited;
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        //  [2, 1, 1, 1, 1, 1, 3]
        //  [2, 1, 3, 4]
        int sum = 0;
        len = nums.length;
        for (int i : nums) {
            sum += i;
        }

        if (sum % k != 0) return false;
        visited = new HashSet<>();
        set = new HashSet<>();

        if (canPartition(nums, 1, k, 0, 0, sum/k))
            return true;

        return false;
    }

    public static boolean canPartition(int[] nums,int kCurr,int k,int runningSum, int i, int reqSum) {
        if (kCurr > k) {
            return  true;
        } else if (runningSum == reqSum) {
            return canPartition(nums, kCurr+1, k, 0, 0, reqSum);
        } else if (i >= len || runningSum > reqSum || set.contains(runningSum)) {
            return false;
        }

        if (visited.contains(i)) {
            return canPartition(nums, kCurr, k, runningSum, i+1, reqSum);
        }

//        if (runningSum == reqSum) {
//            return canPartition(nums, kCurr+1, k, 0, 0, reqSum);
//        }

        visited.add(i);
        if (canPartition(nums, kCurr, k, runningSum+nums[i], i+1, reqSum)) {
            return true;
        }
        visited.remove(i);
        if (canPartition(nums, kCurr, k, runningSum, i+1, reqSum)) {
            return true;
        }

        set.add(runningSum);
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums, 4));
    }
}
