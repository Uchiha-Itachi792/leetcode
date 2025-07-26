package com.itachi.leetcode.strings;

public class ReverseString {
    public static void main(String[] args) {

    }

    //双指针
    //344. 反转字符串
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    //541. 反转字符串 II

    /**
     * 反转前k个字符，因此头指针总是 i = i+2k，而尾指针的值为 头指针+k-1
     */
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i = i + 2 * k) {
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            while (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        System.out.println("Hello World");
        return new String(ch);
    }
}
