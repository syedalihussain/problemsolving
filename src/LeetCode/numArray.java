package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class numArray {

    int[] tree;
    int[] nums;

    public numArray(int[] nums) {
        int len = nums.length;
        tree = new int[2*len];
        this.nums = nums;
        buildTree(0, 0, len-1);
    }

    private void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = start + (end - start) / 2;

            buildTree(2*node+1, start, mid);
            buildTree(2*node+2, mid+1, end);

            List<Integer> list = new ArrayList<>();

            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9, 11};
        numArray array = new numArray(nums);

    }
}
