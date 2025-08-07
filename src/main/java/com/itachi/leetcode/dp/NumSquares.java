package com.itachi.leetcode.dp;

public class NumSquares {
    public static void main(String[] args) {
        new NumSquares().numSquares(12, false);
    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) { //容量
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) { //物品
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    public int numSquares(int n, boolean flag) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i * i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= i * i && dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i]+1);
                }
            }
        }
        return dp[n];
    }
}
