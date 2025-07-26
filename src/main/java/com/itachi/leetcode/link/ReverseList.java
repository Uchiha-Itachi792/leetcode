package com.itachi.leetcode.link;
//206. 反转链表。高频
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode();

        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newNode = new ListNode();
        //头插法
        while (head != null) {
            ListNode next = head.next;
            head.next = newNode.next;
            newNode.next = head;
            head = next;
        }
        return newNode;
    }
}
