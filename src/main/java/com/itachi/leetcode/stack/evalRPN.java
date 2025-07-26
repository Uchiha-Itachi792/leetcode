package com.itachi.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

//150.逆波兰表示式求值
public class evalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        //遇到数字就往栈里面存储
        //遇到操作符就弹出栈里面的数字，然后利用遍历到的操作符进行计算，然后将计算结果放进栈里面
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
