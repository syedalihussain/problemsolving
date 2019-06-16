package CtCI_Recursion_and_Dynamic_Programming;

public class recursiveMultiple_08_05 {
	public static int minProduct(int a, int b) {
		int smaller = a < b ? a : b;
		int bigger = a < b ? b : a;
		return minProductHelper(smaller, bigger);
	}

	private static int minProductHelper(int smaller, int bigger) {
		if (smaller == 0)
			return 0;
		else if (smaller == 1)
			return bigger;

		int s = smaller >> 1; //	Dividing by two
		int halfProd = minProductHelper(s, bigger);

		if (smaller % 2 == 0) {
			return 2 * halfProd;
		} else {
			return 2 * halfProd + bigger;
		}
	}

	public static void main(String[] args) {

	}
}
