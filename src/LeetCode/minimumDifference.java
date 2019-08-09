package LeetCode;

import java.util.Arrays;

public class minimumDifference {
    public static int minimumDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]-arr[i-1]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 3, 5, -1, 10, 12};
        System.out.println(minimumDifference(arr));
    }
}
