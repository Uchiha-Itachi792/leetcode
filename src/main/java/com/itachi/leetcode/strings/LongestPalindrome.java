package com.itachi.leetcode.strings;

/**
 * 回文串的特点是：
 * 如果一个字符串是回文串，那么将有两个特点：
 * 1. 首尾两个字母一定相等
 * 2. 它首尾的两个字母去除之后，它仍然是个回文串，即也满足特点1
 * 因此公式为:若 (Check(S[i+1,j-1]) =true && S[i] = S[j])，那么Check(S[i,j]) =true
 * 除此之外，自己本身就是个回文串
 * 使用动态规划，做表
 * /**
 * B   A   B   A   B
 * B  T   F   T   F   F
 * A      T   F   T   F
 * B          T   F   T
 * A              T   F
 * B                  T
 */


public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));

    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();

        if (len < 1 || (len == 2 && chars[0] == chars[1])) {
            return s;
        }

        int max = 1;
        int begin = 0;

        // 动态规划的二维数组
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串(也就是自己本身就是个回文串)
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }


        //外层循环是枚举子串的长度：比如对于BABAB而言，枚举为：BAB，BABA，BABAB
        //并且也充当右指针的作用
        for (int i = 1; i < s.length(); i++) {
            //充当左指针
            for (int j = 0; j < i; j++) {
                if (chars[i] != chars[j]) {
                    dp[j][i] = false;
                } else {
                    //去除前后的字符之后，若只剩了一个字符，那么一定是回文串
                    if ((i - 1) - (j + 1) < 1) {
                        dp[j][i] = true;
                    } else {
                        //否则参考dp[i + 1][j - 1]的值
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    begin = j;
                }
            }
        }

        return s.substring(begin, begin + max);
    }
}
