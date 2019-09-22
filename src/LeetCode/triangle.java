package LeetCode;

import java.util.*;

public class triangle {


    public static int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size(), sum = 0;
        int l, r, c, b;
        for (int h = height-2; h >= 0; h--) {
            List<Integer> current = triangle.get(h);
            List<Integer> bottom = triangle.get(h+1);
            for (int i = 0; i < current.size(); i++) {
                l = (i == 0 ? bottom.get(0) : bottom.get(i-1));
                r = (i == current.size()-1 ? bottom.get(i) : bottom.get(i+1));
                b = bottom.get(i);
                c = current.get(i) + Math.min(b, Math.min(l,r));
                current.set(i, c);
            }
        }
        return triangle.get(0).get(0);
    }

    public static Integer[] memo;
    public static int height;
    public static int minimumTotalDp(List<List<Integer>> triangle) {

        height = triangle.size();
        memo = new Integer[height];

        return dp(0, triangle, 0);
    }

    public static int dp(int l, List<List<Integer>> t, int i) {
        if (l >= height) {
            return 0;
        } else if (memo[l] != null)
            return memo[l];

        List<Integer> list = t.get(l);
        int cost = list.get(i);
        cost += Math.min(dp(l+1, t, i), dp(l+1, t, i+1));

        memo[l] = cost;
        return cost;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(); l1.add(2);
        List<Integer> l2 = new ArrayList<>(); l2.add(3); l2.add(4);
        List<Integer> l3 = new ArrayList<>(); l3.add(6); l3.add(5); l3.add(7);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1); triangle.add(l2); triangle.add(l3);
        System.out.println(minimumTotalDp(triangle));
    }
}
