package CTCI_Linked_Lists;

public class partition_2_4 {
	/*	Questions
		Can I create a new Linked List?
	 */
	public static Node partition(Node node,int val) {
		Node head = node;
		Node tail = node;

		while (node != null) {
			Node next = node.next;
			if (node.data < val) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;

		return head;
	}




	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();

		list.append(3);
		list.append(5);
		list.append(8);
		list.append(5);
		list.append(10);
		list.append(2);
		list.append(1);

		Node node = list.head;

		Node res = partition(node, 5);
		while (res != null) {
			System.out.println(res.data);
			res = res.next;
		}

	}
}
