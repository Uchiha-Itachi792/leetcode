package com.itachi.leetcode.link;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode tmp = head;
        while (tmp != null) {
            if (visited.contains(tmp)) {
                return tmp;
            }else {
                visited.add(tmp);
            }
            tmp = tmp.next;
        }
        return null;
    }
}
