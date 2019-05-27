package CTCI_Linked_Lists;

import java.util.*;

public class palindrome_2_6 {

	public static boolean isPalindrome1(Node node) {
		//	This function only tells if a Linked List is a permutation of a Palindrome
		if (node == null) return false;
		if (node.next == null) return true;

		Node lead = node;
		Node lag = node;
		int bitVector = 0;
		boolean toggle = false;

		while (lead!=null) {
			lead = lead.next;
			if (toggle) {
				bitVector = doToggle(bitVector, lag.data);
				lag = lag.next;
			}
			toggle = !toggle;
		}
		if (!toggle)
			bitVector = doToggle(bitVector, lag.data);

		while (lag != null) {
			lag = lag.next;
			if (lag != null)
				bitVector = doToggle(bitVector, lag.data);
		}
		System.out.println(bitVector);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}

	private static boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}

	private static int doToggle(int bitVector, int data) {
		int mask = 1 << data;

		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}

	public static boolean isPalindrome2(Node node) {
		if (node == null) return false;
		if (node.next == null) return true;
		Node lead = node;
		Node lag = node;
		boolean toggle = false;
		Stack<Integer> stack = new Stack<>();

		while (lead!=null) {
			lead = lead.next;
			if (toggle) {
				stack.push(lag.data);
				lag = lag.next;
			}
			toggle = !toggle;
		}
		if (toggle)
			lag = lag.next;

		int pop;
		while (lag!=null) {
			pop = stack.pop();
			if (lag.data!=pop)
				return false;
			lag = lag.next;
		}
		return true;
	}
	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();

		list.append(7);
		list.append(1);
		list.append(5);
		list.append(1);
//		list.append(7);

		System.out.println(isPalindrome1(list.head));
		System.out.println(isPalindrome2(list.head));
		String str = "Hello";
		StringBuilder sb = new StringBuilder(str);
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		HashMap<String, Integer> hm = new HashMap<>();
		List<String> newList = new ArrayList<>();

		newList.add(str);
	}
}
