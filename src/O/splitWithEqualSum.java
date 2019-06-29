package O;

public class splitWithEqualSum {
	//	Add in the functionality of handling overrunning
	public static int split(int[] arr) {
		//	[-1, 3, -4, 5, 1, -6, 2, 1] == 1
		//	[4, -2, 4]

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		int newSum = 0;
		int index = 0;
		//	sum    2, -1
		//	newSum -1,
		while (index < arr.length) {
			sum -= arr[index];
			if (newSum == sum) {
				return index;
			}
			newSum += arr[index];
			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = {-1, 3, -4, 5, 1, -6, 2, 1};
		System.out.println(split(array));
		String s1 = "i am";
		String s2 = "i am";
		System.out.println(s1);
		System.out.println(s2);
	}
}
