package CtCI_Stacks_and_Queues;

import java.util.NoSuchElementException;

public class QueueStack {
	/*
		Implement a queue using stacks.
		We need to change pop and push.
	 */

	private MyStack<Integer> newest;
	private MyStack<Integer> oldest;

	public QueueStack() {
		newest = new MyStack<>();
		oldest = new MyStack<>();
	}

	public void push(int value) {
		newest.push(value);
	}

	public int pop() {
		if (newest==null && oldest==null)
			throw new NullPointerException();
		if (oldest==null) {
			while(!newest.isEmpty()) {
				oldest.push(newest.pop());
			}
		}
		return oldest.pop();
	}

	public int peek() {
		if (newest==null && oldest==null)
			throw new NullPointerException();
		if (oldest==null) {
			while(!newest.isEmpty()) {
				oldest.push(newest.pop());
			}
		}
		return oldest.peek();
	}
}
