package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class smallestStringWithSwaps {
    /*
            "dcab"
            [[0,3],[1,2]]
            "dcab"
            [[0,3],[1,2],[0,2]]
            "cba"
            [[0,x   1],[1,2]]
            "vbjjxgdfnru"
            [[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
     */
    public static int totalPairs;
    public static HashSet<String> set;
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] sArray = s.toCharArray();
        set = new HashSet<>();
        totalPairs = pairs.size();
        sort(s, pairs);
        String min = "|";
        System.out.println(set);
        for (String str : set) {
            min = (str.compareTo(min) < 0 ? str : min);
        }
        return min;
    }
    public static void sort(String s, List<List<Integer>> pairs) {
        if (set.contains(s)) {
            return;
        }
        set.add(s);
        int j, k;
        char c;
        for (int i = 0; i < totalPairs; i++) {
            char[] lArray = s.toCharArray();
            j = pairs.get(i).get(0); k = pairs.get(i).get(1);
            // don't swap and check
            sort(new String(lArray), pairs);
            set.add(new String(lArray));
            // swap and check
            swap(lArray, j, k);
            sort(new String(lArray), pairs);
            set.add(new String(lArray));
        }
    }
    public static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3);
        pairs.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        pairs.add(list);
        list = new ArrayList<>();
        list.add(0);
        list.add(2);
        pairs.add(list);
        System.out.println(pairs);
        String str = "vbjjxgdfnru";
        System.out.println(smallestStringWithSwaps(str, pairs));
    }
}
