package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class numbersWithACertainDigit {



	public static List<Integer> numbersWithDigit(int[] nums, int digit) {
		List<Integer> res = new ArrayList<>();
		for (int current : nums) {
			int i = current;
			while (i != 0) {
				int d = i % 10;
				if (d == digit) {
					res.add(current);
					break;
				}
				i = i / 10;
			}
		}
		return res;
	}

	public static void main(String[] args) {
//		int[] nums = {234, 123, 321, 555, 214, 333, 331, 133, 000};
//		List<Integer> res = numbersWithDigit(nums, 3);
//		System.out.println(res);

//		List<Integer> temp = new ArrayList<>(Collections.nCopies(nums.length, 0));
//		temp.add(2, 1);
//		System.out.println(temp);
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> temp = new ArrayList<>(Collections.nCopies(nums.length, 0));
		for (int num : nums) {
			temp.add(num-1, 1);
		}
		System.out.println(temp);
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i) != 1) {
				System.out.println(i);
				res.add(i+1);
			}
		}
	}
}
