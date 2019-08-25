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

    public static void main(String[] args) {
        List<HashSet<Integer>> rowSets = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        rowSets.add(set);
        HashSet<Integer> newset = rowSets.get(0);
        newset.add(2);
        HashSet<Integer> latest = rowSets.get(0);
        String[] transactions = new String[]{"alice,50,100,beijing", "alice,20,800,mtv"};
        Comparator<String> cmp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                Integer time1 = Integer.valueOf(o1.split(",")[1]);
                Integer time2 = Integer.valueOf(o2.split(",")[1]);
                return time1.compareTo(time2);
            }
        };
        Arrays.sort(transactions, cmp);
    }
}
