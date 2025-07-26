package com.itachi.leetcode.link;

public class MyLinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        int i = myLinkedList.get(4);

        myLinkedList.deleteAtIndex(1);


        System.out.println("");
    }
}
