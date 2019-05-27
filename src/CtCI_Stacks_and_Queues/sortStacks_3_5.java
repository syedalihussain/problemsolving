package CtCI_Stacks_and_Queues;

import java.util.Stack;

public class sortStacks_3_5 {

	/*
	Just use one stack
	 */
	public static void sortStack(Stack<Integer> s) {

		Stack<Integer> sorted = new Stack<>();
		int min = Integer.MAX_VALUE;

		while(!s.isEmpty()) {
			min = s.pop();
			while(!sorted.isEmpty() && sorted.peek()>min) {
				s.push(sorted.pop());
			}
			sorted.push(min); //	Mistake sorted.push(s.pop())
		}

		while(!sorted.isEmpty()) {
			s.push(sorted.pop());
		}
	}


	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(6);
		stack.push(3);
		stack.push(10);
		stack.push(2);
		stack.push(1);
		stack.push(9);
		stack.push(8);
		stack.push(5);

		sortStack(stack);
		int stackSize = stack.size();
		for (int i=0; i<stackSize; i++) {
			System.out.println("Stack pop: " + stack.pop());
		}

	}
}
