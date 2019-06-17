package CtCI_Recursion_and_Dynamic_Programming;

import java.util.Stack;

class Tower {
	private Stack<Integer> disks;

	public Tower() {
		disks = new Stack<>();
	}

	public void add(int d) {
		if (!disks.isEmpty() && d >= disks.peek()) {
			System.out.println("Error adding disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTop(Tower destination) {
		destination.add(disks.pop());
	}

	public void moveDisks(int numOfDisks, Tower buffer, Tower destination) {
		if (numOfDisks >= 1) {
			moveDisks(numOfDisks - 1, destination, buffer);
			moveTop(destination);
			buffer.moveDisks(numOfDisks - 1, this, destination);
		}
	}

	public Stack<Integer> getStack() {
		return disks;
	}
}

public class towersOfHanoi_08_06 {



	public static void main(String[] args) {
		int n = 3;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < n; i++) {
			towers[i] = new Tower();
		}

		//	Make the first tower of height h;
		int h = 5;
		for (int i = 5; i >= 1; i--) {
			towers[0].add(i);
		}

		towers[0].moveDisks(h, towers[1], towers[2]);
		Stack<Integer> stack = towers[2].getStack();
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
