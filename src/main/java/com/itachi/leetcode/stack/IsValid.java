package com.itachi.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid {

    public static void main(String[] args) {
        boolean valid = isValid("([[{])]}");
        System.out.println(" ");

    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //遍历结束，如果栈为空，则括号全部匹配
        return deque.isEmpty();
    }
}
