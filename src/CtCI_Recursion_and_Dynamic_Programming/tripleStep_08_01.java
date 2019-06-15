package CtCI_Recursion_and_Dynamic_Programming;

public class tripleStep_08_01 {

	public static int countPaths(int n) {
		int res = 0;
		int s3 = 1, s2 = 0, s1 = 0;
		for (int i = n; i > 0; i--) {
			res = s1 + s2 + s3;
			s1 = s2;
			s2 = s3;
			s3 = res;
		}
		return res;
	}

	public static int countWays(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2]
					+ res[i - 3];
		}

		return res[n];
	}

	public static void main(String[] args) {
		int totalNumOfSteps = 5;
		System.out.println("Total paths for " + totalNumOfSteps + " are : " + countPaths(totalNumOfSteps));
		System.out.println("Total ways for " + totalNumOfSteps + " are : " + countWays(totalNumOfSteps));
	}
}
