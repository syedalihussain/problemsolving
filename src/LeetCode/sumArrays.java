package LeetCode;

import java.util.Arrays;

public class sumArrays {

	public static int[] sumArrays(int[] a1, int[] a2) {
		int i1 = a1.length - 1;
		int i2 = a2.length - 1;
		int sum, carry = 0, d1, d2;
		int[] res = new int[i1 > i2 ? (i1 + 2) : (i2 + 2)];
		int i3 = res.length - 1;
		while (i1 >= 0 || i2 >= 0) {
			sum = 0;
			d1 = i1 >= 0 ? a1[i1--] : 0;
			d2 = i2 >= 0 ? a2[i2--] : 0;
			sum = carry + d1 + d2;
			d1 = sum % 10;
			res[i3--] = d1;
			carry = sum >= 10 ? 1 : 0;
		}
		if (carry == 1) {
			res[i3] = 1;
			return res;
		} else {
			return Arrays.copyOfRange(res, 1, res.length);
		}
	}

	public static void main(String[] args) {
		int[] array1 = {9, 9, 9, 9};
		int[] array2 = {9, 9};
		int[] sum = sumArrays(array1, array2);

		for (int i : sum) {
			System.out.print(i + " ");
		}
	}
}
