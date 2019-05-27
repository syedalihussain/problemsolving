package CtCI_Stacks_and_Queues;

public class stackMin_3_2 {
	/*
		Answer: Include a stack that
	 */
	public static void changeInt(Integer i) {
		i = 9;
	}
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(6);
		stack.push(3);
		stack.push(10);
		stack.push(2);
		stack.push(1);
		stack.push(9);
		stack.push(8);
		stack.push(5);

		int stackSize = stack.size();
		for (int i=0; i<stackSize; i++) {
			System.out.println("Stack top: " + stack.peek() + ", Stack min: " + stack.min());
			stack.pop();
		}
	Integer Int = 2;
		changeInt(Int);
		System.out.println(Int);
	}
}
