package com.itachi.leetcode.dp;
//123. 买卖股票的最佳时机 III
public class MaxProfit3 {
    public int maxProfit(int[] prices) {

        //初始资金为0
//        0.没有操作(其实我们也可以不设置这个状态)
//        1. 第一次持有股票
//        2.第一次不持有股票
//        3.第二次持有股票
//        4.第二次不持有股票

        //dp[i][0]代表第i天不持有股票的产生的最大价值。它分为两个情况：
        // 前一天就不持有：dp[i][0] = dp[i-1][0]
        // 前一天就持有但是第i天卖掉：dp[i][0] = dp[i-1][1] +prices[i]
        //两者取最大值

        //dp[i][1]代表第i天持有股票的产生的最大价值。它分为两个情况：
        // 前一天就持有：dp[i][1] = dp[i-1][1]
        // 前一天就不持有但是第i天买进来：dp[i][1] = -prices[i] + dp[i - 1][0]  (可以买卖多次，因此需要加上之前所得到的收益，之前的肯定是已经卖出的)
        // 两者取最大值


        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0; //不持有股票，初始资金为0
        dp[0][1] = -prices[0]; //持有股票，初始资金为 0-prices[0] = -prices[0]

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);

        }
        return dp[prices.length - 1][0]; //最后求结果的时候，肯定是不持有股票
    }
}
