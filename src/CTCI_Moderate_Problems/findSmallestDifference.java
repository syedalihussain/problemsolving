package CTCI_Moderate_Problems;

import java.util.Arrays;

public class findSmallestDifference {

	public static int findSmallestDifference(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);

		int len1 = array1.length, len2 = array2.length;
		int i1 = 0, i2 = 0;
		int smallestDifference = Integer.MAX_VALUE;
		//	{1, 2, 11, 15}
		//	{4, 12, 19, 23, 127, 235}

		while (i1 < len1 && i2 < len2) {
			int diff = Math.abs(array1[i1] - array2[i2]);
			if (diff < smallestDifference)
				smallestDifference = diff;

			if (array1[i1] < array2[i2])
				i1++;
			else
				i2++;
		}

		return smallestDifference;
	}


	public static void main(String[] args) {
		System.out.println("Hello");
		int[] arr1 = {1, 2, 3, 5};
		int[] arr2 = Arrays.copyOfRange(arr1, 0, 	arr1.length);
		arr1[0] = 9;
		System.out.println(arr2.length);

	}


}
