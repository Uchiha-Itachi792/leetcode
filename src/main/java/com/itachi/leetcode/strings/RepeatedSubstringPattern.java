package com.itachi.leetcode.strings;
//459.重复的子字符串
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        repeatedSubstringPattern("abcabc");

        System.out.println( repeatedSubstringPattern("abcaabcaabca"));


    }

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
