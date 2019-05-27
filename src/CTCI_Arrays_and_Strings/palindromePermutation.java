package CTCI_Arrays_and_Strings;

public class palindromePermutation {


	public static boolean palindromePermutation(String s) {

		int bitVector = 0;
		char c;
		char[] charArray = s.toLowerCase().toCharArray();
		for (int i=0; i<s.length(); i++) {
			c = charArray[i];
			if (c != ' ') {
				int x = c - 'a';
				bitVector = toggle(bitVector, x);
			}
		}
		return bitVector == 0 || ((bitVector & (bitVector-1)) == 0);
	}

	private static int toggle(int bitVector, int x) {
		if (x<0) return bitVector;

		int mask = 1 << x;

		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}


	public static void main(String[] args) {
		String str = "tactcoa";
		System.out.println(palindromePermutation(str));

	}
}
