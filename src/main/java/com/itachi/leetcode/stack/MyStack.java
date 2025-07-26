package com.itachi.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 先放在辅助队列中
        queue2.offer(x);
        // 将正式队列中的数据全部放进辅助队列中，假设此次进来的是c
        // 比如正式队列中的元素为： a,b，按照先进先出的原则，应该先出a
        // 但是全部放入临时队列中之后，顺序为c,a,b，
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        // 最后交换queue1和queue2，将元素都放到queue1中
        queue2 = queueTemp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
