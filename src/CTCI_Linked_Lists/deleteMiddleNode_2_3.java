package CTCI_Linked_Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class deleteMiddleNode_2_3 {

	public static boolean deleteNode(Node node) {
		if (node == null || node.next == null) return false;

		Node next = node.next;

		node.data = next.data;
		node.next = next.next;
		return true;
	}



	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();

		list.append(1);
		list.append(3);
//		list.append(2);
//		list.append(3);
//		list.append(1);
//		list.append(2);

		Node node = list.head;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(1));
		queue.add(new Node(2));
		queue.add(new Node(7));
		System.out.println(queue.pop().data);
		System.out.println(queue.pop().data);
	}
}
