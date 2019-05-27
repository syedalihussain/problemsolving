package LeetCode;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.*;

public class reverseListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for (int i = 1; i < m; i++) {
			pre = pre.next;
		}

		ListNode start = pre.next;
		ListNode tail = start;
		ListNode newhead = null;
		for (int i = m; i <= n; i++) {
			ListNode next = start.next;
			start.next = newhead;
			newhead = start;
			start = next;
		}

		pre.next = newhead;
		tail.next = start;
		return dummy.next;
	}

	public static void main(String[] args) {


	}
}
