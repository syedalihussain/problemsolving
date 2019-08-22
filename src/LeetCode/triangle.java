package LeetCode;

import java.util.ArrayList;
import java.util.List;

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
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(){
            {
                add(2);
            }
        });
        lists.add(new ArrayList<>(){
            {
                add(3);
                add(4);
            }
        });
        lists.add(new ArrayList<>(){
            {
                add(6);
                add(5);
                add(7);
            }
        });
        lists.add(new ArrayList<>(){
            {
                add(4);
                add(1);
                add(8);
                add(3);
            }
        });
        System.out.println(minimumTotal(lists));
    }
}
