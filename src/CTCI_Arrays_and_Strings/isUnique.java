package CTCI_Arrays_and_Strings;

public class isUnique {

	public static boolean isUnique(String word) {
		char[] charArray = word.toLowerCase().toCharArray();
		int[] intArray = new int[26];
		int c;
		for(int i=0; i<word.length(); i++) {
			c = (int) charArray[i]-97;
			if (intArray[c] != 0)
				return false;
			intArray[c]++;
		}
		return true;
	}



	public static void main(String[] args) {
		// write your code here
		String word = "ABCAE";


		System.out.println(isUnique(word) ? "Unique" : "Not Unique");
	}
}
