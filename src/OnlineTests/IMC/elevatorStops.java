package OnlineTests.IMC;

import java.util.HashMap;
import java.util.HashSet;

public class elevatorStops {

	public static int calculateElevatorStops(int[] A, int[] B, int M, int X, int Y) {
		//	X num of people capacity
		//	Y weight capacity
		//	M num of floors in the building
		//	B destinations of people
		int head = 0;
		int len = A.length;
		HashSet<Integer> hs;
		int stops = 0;
		int currentCapacity = 0;
		int sumWeight = 0;
		int sumPeople = 0;
		while (head < len) {
			hs = new HashSet<>();
			stops = 0;
			sumWeight = 0;
			sumPeople = 0;
			while (head < len && sumPeople < X && sumWeight < Y) {
				int currentWeight = B[head];
			}
		}


		return 0;
	}

	public static void exceptionThrowingMethod() throws IndexOutOfBoundsException {
		int i = 0;
	}


	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("None", "City");
	}
}
