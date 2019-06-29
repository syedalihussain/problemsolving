package O.I;

import java.util.HashSet;

public class elevatorStops {

	public static int calculateElevatorStops(int[] A, int[] B, int M, int X, int Y) {
		//	X num of people capacity
		//	Y weight capacity
		//	M num of floors in the building
		//	B destinations of people
		//	A = [60, 80, 40]
		//	B = [ 2,  3,  5]
		int numOfPeople = A.length;
		int stops = 0;
		HashSet<Integer> set;
		int i = 0;
		int currentCapacity;
		int currentWeight;
		while (i < numOfPeople) {
			set = new HashSet<>();
			currentCapacity = 0;
			currentWeight = 0;
			//	Take care of edge cases
			while (i < numOfPeople && currentCapacity < X) {
				if ((A[i] + currentWeight) <= Y) {
					currentWeight += A[i];
					currentCapacity++;
					if (!set.contains(B[i])) {
						set.add(B[i]);
					}
				} else {
					break;
				}
				i++;
			}
			stops += set.size() + 1;
		}


		return stops;
	}



	public static void main(String[] args) {
		int[] A1 = {60, 80, 40};
		int[] B1 = {2,  3,  5};
		System.out.println(calculateElevatorStops(A1, B1, 5, 2, 200));

		int[] A2 = {40, 40, 100, 80, 20};
		int[] B2 = {3, 3, 2, 2, 3};
		System.out.println(calculateElevatorStops(A2, B2, 3, 5, 200));
	}
}
