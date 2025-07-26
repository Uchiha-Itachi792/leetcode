package com.itachi.leetcode.link;
//707. 设计链表
public class MyLinkedList {
    ListNode head; //虚拟节点，本身不存储任何数据
    int size;

    public MyLinkedList() {
        head = new ListNode();
    }

    public int get(int index) {
        ListNode tmp = head;
        if (index < 0 || index >= size) {
            return -1;
        }
        while (index >= 0) {
            tmp = tmp.next;
            index--;
        }
        return tmp.val;
    }

    //将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head.next = newHead;
        size ++;
    }

    // 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val) {
        ListNode tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new ListNode(val);
        size++;
    }
    // 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
    // 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
    // 如果 index 比长度更大，该节点将 不会插入 到链表中。
    public void addAtIndex(int index, int val) {
        //此处index可以大于size，用户可能希望插入到链表末尾出
        if (index < 0 || index > size) {
            return;
        }

        ListNode tmp = head;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }

        ListNode newNode = new ListNode(val);
        newNode.next=tmp.next;
        tmp.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode tmp = head;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }
        tmp.next = tmp.next.next;

        size--;
    }

}
