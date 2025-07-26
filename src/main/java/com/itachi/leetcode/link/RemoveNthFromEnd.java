package com.itachi.leetcode.link;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        removeNthFromEnd(node, 2);


    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        ListNode slow = tmpHead;
        ListNode fast = tmpHead;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return tmpHead.next;
    }
}
