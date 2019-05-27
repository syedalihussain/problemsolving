package CTCI_Linked_Lists;

public class returnKthtoLast_2_2 {
	/*	Questions
		Can the linked list be empty?
		What do I return if it is empty?
		Do I know the length of the linkedList?
		Can I assume that kth would always lie within length of linked list?
	 */
	public static int findKthtoLast(SingleLinkedList list,int k) {
		/*

		 */
		if (list.head == null) return -1;
		Node lead = list.head;
		Node lag = list.head;
		int gap = 0;
		while (gap < k) {
			lead = lead.next;
			gap++;
			if (lead == null)
				return lag.data;
		}
		while (lead != null) {
			lead = lead.next;
			lag = lag.next;
		}
		return lag.data;
	}

	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();

		list.append(1);
		list.append(3);
//		list.append(2);
//		list.append(3);
//		list.append(1);
//		list.append(2);

		int res = findKthtoLast(list, 2);
		Node node = list.head;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}

		 System.out.println("Kth to last element: " + res);
	}
}
