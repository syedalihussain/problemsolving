package CTCI_Linked_Lists;

import java.util.HashSet;

public class removeDuplicates_2_1 {
	/*	Hints
		Can I use a temporary buffer?
		if a hash table is used then it is super simple
	*/

	public static void removeDuplicates1(SingleLinkedList list) {
		//	Uses a hashtable
		HashSet<Integer> hs = new HashSet<Integer>();
		Node node = list.head;
		Node previous = null;
		while (node != null) {
			if (hs.contains(node.data)) {
				previous.next = node.next;
			} else {
				hs.add(node.data);
				previous = node;
			}
			node = node.next;
		}
	}

	public static void removeDuplicates2(SingleLinkedList list) {
		//	If using a buffer was not allowed
		if (list.head == null) return;
		if (list.head.next == null) return;

		Node lag = list.head;

		while (lag.next != null) {
			Node lead = lag;
			while (lead.next != null) {
				if (lead.next.data == lag.data) {
					lead.next = lead.next.next;
				} else {
					lead = lead.next;
				}
			}
			lag = lag.next;
		}
	}



	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();

		list.append(1);
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(1);
		list.append(2);

		removeDuplicates2(list);
		Node node = list.head;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}

		// System.out.println("Hello");
	}
}
