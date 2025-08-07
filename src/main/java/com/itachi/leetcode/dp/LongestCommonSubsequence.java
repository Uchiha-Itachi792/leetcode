package com.itachi.leetcode.dp;
//1143. 最长公共子序列
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int longl = Math.max(text1.length(), text2.length());
        int shortl = Math.min(text1.length(), text2.length());


        int[][] dp = new int[longl + 1][shortl + 1];
        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < longl; i++) {
            for (int j = 1; j < shortl; j++) {
                //如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
