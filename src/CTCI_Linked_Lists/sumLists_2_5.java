package CTCI_Linked_Lists;

import java.util.LinkedList;

public class sumLists_2_5 {

	/*	Questions
		Will be the same length?
		Can either of the numbers have leading zeros?
		Can I make them the same length?
	 */
	public static Node sumLists(Node n1, Node n2) {
		if (n1==null)
			return n2;
		else if (n2==null)
			return n1;
		int num1;
		int num2;
		int carry = 0;
		int sum, digit;
		SingleLinkedList res = new SingleLinkedList();

		while (n1!=null || n2!=null) {

			if (n1 == null)
				num1 = 0;
			else {
				num1 = n1.data;
				n1 = n1.next;
			}
			if (n2 == null)
				num2 = 0;
			else {
				num2 = n2.data;
				n2 = n2.next;
			}
			sum = num1 + num2 + carry;

			if (sum >= 10) {
				digit = sum % 10;
				res.append(digit);
				carry = 1;
			} else {
				res.append(sum);
				carry = 0;
			}

		}
		if (carry == 1) {
			res.append(1);
		}
		return res.head;
	}

	private static int getNumber(Node n) {
		if (n == null)
			return 0;
		else {
			int res = n.data;
			n = n.next;
			return res;
		}
	}


	public static void main(String[] args) {

		SingleLinkedList num1 = new SingleLinkedList();
		SingleLinkedList num2 = new SingleLinkedList();

		num1.append(1);

		num2.append(9);
		num2.append(9);
		num2.append(9);


//		int d = getNumber(num1.head);
//		System.out.println(num1.head.data);

		Node node = sumLists(num1.head, num2.head);
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		String s = "Hello";
//		System.out.println("Kth to last element: " + res);
	}
}
