package com.itachi.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        new MonotoneIncreasingDigits().monotoneIncreasingDigits(101);
    }

    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length(); //标志位，从这个start Index往后都需要变成9
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
