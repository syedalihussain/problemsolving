package CtCI_Stacks_and_Queues;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
	Stack<Integer> s;

	public StackWithMin() {
		s = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= min()){
			s.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int res = super.pop();
		if (min() == res) {
			s.pop();
		}
		return res;
	}

	public int min() {
		if (s.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s.peek();
		}
	}
}
