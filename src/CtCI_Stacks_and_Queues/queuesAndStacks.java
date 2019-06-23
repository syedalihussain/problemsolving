package CtCI_Stacks_and_Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import sun.awt.image.ImageWatched.Link;

public class queuesAndStacks {


	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < 5; i++) {
			queue.add(i);
			stack.push(i);
		}

		while (!queue.isEmpty()) {
			System.out.println("Stack: " + stack.pop() + ", Queue: " + queue.remove());
		}
	}

}
