package Pramp;

import java.util.*;

public class islandCount {

	public static List<Integer> getQueueList() {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(5);
		queue.add(4);
		queue.add(3);
		queue.add(2);
		queue.add(1);

		return queue;
	}


	public static void main(String[] args) {
		int[][] binaryMatrix = {
				{3,    9,    0,    1,    8},
				{0,    0,    1,    1,    1},
				{1,    0,    0,    1,    0},
				{0,    1,    1,    0,    0},
				{1,    0,    1,    0,    1},
				{7,    0,    1,    0,    5}
		};
		System.out.println(binaryMatrix[0].length);
		System.out.println(binaryMatrix.length);
		System.out.println("Top Right: " + binaryMatrix[0].length);

		System.out.println(getQueueList());
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(3);
		arrayList.add(5);
		int[] list1 = new int[2];
		char c = '1';
		System.out.println(c - 48);


	}
}
