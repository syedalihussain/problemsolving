package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        int[][] arr = new int[][] {{0, 3, 5}, {-1, 10, 12}, {-1, 10, 12}};
        for (int i = 0; i <arr.length; i++) {
            arr[0][i] = Integer.MIN_VALUE;
            arr[i][0] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
        List<Integer> array = new ArrayList<>();
        Collections.sort(array);
    }
}
