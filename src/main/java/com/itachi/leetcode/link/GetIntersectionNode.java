package com.itachi.leetcode.link;

import java.util.HashSet;
import java.util.Set;

//面试题 02.07. 链表相交


public class GetIntersectionNode {

    /**
     * 相交节点的含义为：从该节点开始到最后一个节点，在A链表和B链表中都是一样的
     * 我们可以维护一个set集合(set集合的元素不重复)存储A链表的节点，然后再遍历B链表，若set集合中包含B链表的某个节点，那么就直接返回。
     *
     * 注意：虽然set集合元素不重复，链表A中也可能存在数值相同的节点，但是这些节点都会存储进行Set集合中，
     * 原因是：set集合中存储的是listNode对象，set集合的去重判断是比较的对象地址，因此就算两个listNode的val值是一样的，但是由于是两个不同的对象
     *        依然会被存储进set集合
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
