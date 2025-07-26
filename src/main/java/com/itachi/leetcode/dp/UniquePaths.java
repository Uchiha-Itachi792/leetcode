package com.itachi.leetcode.dp;
//62. 不同路径
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //动态规划表
        //dp[i][j]位置的元素就是可以走的路径数量
        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //当前项的值 = 同一行的前一项 + 同一列的上一项
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
