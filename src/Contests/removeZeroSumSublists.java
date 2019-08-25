package Contests;


import java.util.HashSet;
import java.util.Stack;

public class removeZeroSumSublists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode removeZeroSumSublists(ListNode head) {
        //  [1,2,3,-3,-2]
        //  [1,]
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> queue = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        stack.add(0);
        int runningSum = 0;
        while (head != null) {
            if (head.val != 0) {
                runningSum += head.val;
                if (set.contains(runningSum)) {
                    while (!stack.isEmpty() && stack.peek() != runningSum) {
                        set.remove(stack.pop());
                    }
                } else {
                    stack.add(runningSum);
                    set.add(runningSum);
                }
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
        int p = 0;
        ListNode newHead = new ListNode(queue.pop());
        ListNode res = newHead;
        while (!queue.isEmpty()) {
            newHead.next = new ListNode(queue.peek()-p);
            p = queue.pop();
            newHead = newHead.next;
        }
        return res.next;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        System.out.println(stack.contains(2));
    }
}
