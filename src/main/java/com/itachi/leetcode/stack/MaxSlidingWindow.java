package com.itachi.leetcode.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//239.滑动窗口最大值
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 3, -1, -3, -5, -3, -6, -7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 创建一个单调队列，单调队列的要求是：
     * add()添加元素： 添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出，否则入列
     * poll()弹出元素：就是滑动窗口的移动，每滑动一次，就需要从队尾挪出一个元素，但是要弹出的数值是否等于队列出口的数值，如果相等则弹出
     */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MyQueueDemo myQueue = new MyQueueDemo();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        //i为滑动窗口的右标，i-k为滑动窗口的左标
        for (int i = k; i < nums.length; i++) {
            //准备弹出滑动窗口左标的值，需要判断
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

class MyQueueDemo {
    Deque<Integer> deque = new LinkedList<>();


    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}

