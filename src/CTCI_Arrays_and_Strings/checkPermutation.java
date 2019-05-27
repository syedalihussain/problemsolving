package CTCI_Arrays_and_Strings;

import java.util.Arrays;

public class checkPermutation {
	//	Assuming that spaces and character case is taken into consideration
	public static boolean checkPermutation(String a, String b) {

		if (a.length()!=b.length())
			return false;

		int[] intArray = new int[128];
		char[] charCountsA = a.toCharArray();
		char[] charCountsB = b.toCharArray();
		int j;

		for(int i=0; i<a.length(); i++) {
			j = (int) charCountsA[i];
			intArray[j]++;
			j = (int) charCountsB[i];
			intArray[j]--;
		}

		for(int i : intArray){
			if(i != 0)
				return false;
		}
		return true;
	}




	public static void main(String[] args) {
		String A = "god";
		String B = "dog";
		System.out.println(checkPermutation(A,B));
	}
}
