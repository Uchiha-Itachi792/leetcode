package com.itachi.leetcode.link;
//203. 移除链表元素
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        //添加一个虚拟节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //tmp节点用于遍历
        //删除节点的时候，应该通过node.next来判断是否是被删除节点
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}
