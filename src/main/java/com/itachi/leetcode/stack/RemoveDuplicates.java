package com.itachi.leetcode.stack;

import java.util.Stack;
//1047.删除字符串中的所有相邻重复项
public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        removeDuplicates(s);
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        String str = "";
        //剩余的元素即为不重复的元素
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;

    }
}
