package CtCI_Stacks_and_Queues;

import java.util.NoSuchElementException;

public class MyQueue<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	}

	private QueueNode<T> head;
	private QueueNode<T> tail;

	public void add(T item) {
		QueueNode<T> t = new QueueNode<T>(item);
		if (tail!=null) {
			tail.next = t;
		}
		tail = t;
		if (head==null) {
			head = tail;
		}
	}

	public T remove() {
		if (head == null) throw new NoSuchElementException();
		T res = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return res;
	}

	public T peek() {
		if (head == null) throw new NoSuchElementException();
		return head.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

}
