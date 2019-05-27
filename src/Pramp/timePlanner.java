package Pramp;

public class timePlanner {
	static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
		// your code goes here
		if (slotsA.length == 0 || slotsB.length == 0) {
			return new int [0];
		}
		int i = 0, j = 0;
		int lenA = slotsA.length;
		int lenB = slotsB.length;
		while (i < lenA && j < lenB) {
			int startTime = Math.max(slotsA[i][0], slotsB[j][0]);
			int endTime = Math.min(slotsA[i][1], slotsB[j][1]);

			if ((endTime - startTime) >= dur) {
				int[] res = {startTime, startTime + dur};
				return res;
			}

			if (slotsA[i][1] < slotsB[j][1]) {
				i++;
			} else {
				j++;
			}

		}
		return new int[0];
	}

	public static void main(String[] args) {
		int[][] slotsA = {{7, 12}};
		int[][] slotsB = {{2, 11}};
		int[] res = meetingPlanner(slotsA, slotsB, 5);
	}
}
