package CTCI_Linked_Lists;

class Node {
	Node next = null;
	int data;

	public Node(int d) {
		this.data = d;
	}
}

public class SingleLinkedList {
	Node head;


	public void append(int d) {
		if (head == null) {
			head = new Node(d);
			return;
		}

		Node current = head;

		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node(d);
	}

	public void prepend(int d) {
		Node newHead = new Node(d);
		newHead.next = head;
		head = newHead;
	}

	public void delete(int d) {
		if (head == null)
			return;
		if (head.data == d) {
			head = head.next;
			return;
		}


		Node current = head;
		while(current.next != null) {
			if (current.next.data == d) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
}
