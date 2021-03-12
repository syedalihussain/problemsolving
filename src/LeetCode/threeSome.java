package LeetCode;

import java.util.*;

public class threeSome {
    public static List<List<Integer>> threeSumIntegers(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList();
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int i = 0;
        while(i < len - 2) {
            int a = nums[i];
            if (set.contains(a)) {
                i++;
                continue;
            }
            set.add(a);
            int j = i + 1;
            int k = len - 1;
            set2 = new HashSet<>();
            //  [-4,-1,-1,0,1,2]
            boolean k_boolean = false;
            while (j < k) {
                int b = nums[j];
                int c = nums[k];
                if(set2.contains(b) && !k_boolean) {
                    j++;
                    k_boolean = false;
                    continue;
                }
                set2.add(b);
                int sum = b + c;
                System.out.println("Sum: " + sum);
                System.out.println("a: " + a);
                System.out.println("j: " + j);
                System.out.println("k: " + k);
                if (sum == -a) {
                    System.out.println("a:" + a + ", b:" + b + ", c:" + c);
                    res.add(new ArrayList<>(){{
                        add(a);
                        add(b);
                        add(c);
                    }});
                    j++;
                    // 2 > 1
                } else if (sum > -a) {
//                    System.out.println("Before k--: " + k);
                    k_boolean = true;
                    k--;
//                    System.out.println("After k--: " + k);
                } else {
                    j++;
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0};
        List<List<Integer>> list = threeSumIntegers(arr);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
        String str = "abcd";
        StringBuilder sb = new StringBuilder();
        System.out.println(5/2);
    }
}
