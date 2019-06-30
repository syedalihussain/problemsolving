package LeetCode;

import java.util.*;

public class reverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		LinkedList<ListNode> stack = new LinkedList<>();
		ListNode current = head;
		while (current != null) {
			stack.push(current);
			current = current.next;
		}
		ListNode dummy = new ListNode(0);
		current = dummy;
		while (stack.size() > 0) {
			current.next = stack.removeFirst();
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.reverse().toString();
	}
}
