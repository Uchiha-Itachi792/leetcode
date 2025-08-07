package com.itachi.leetcode.dp;
//122. 买卖股票的最佳时机 II
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] nums = new int[] {7,1,5,3,6,4};
        new MaxProfit2().maxProfit2(nums);
    }

    public int maxProfit2(int[] prices) {

        //初始资金为0

        //dp[i][0]代表第i天不持有股票的产生的最大价值。它分为两个情况：
        // 前一天就不持有：dp[i][0] = dp[i-1][0]
        // 前一天就持有但是第i天卖掉：dp[i][0] = dp[i-1][1] +prices[i]
        //两者取最大值

        //dp[i][1]代表第i天持有股票的产生的最大价值。它分为两个情况：
        // 前一天就持有：dp[i][1] = dp[i-1][1]
        // 前一天就不持有但是第i天买进来：dp[i][1] = -prices[i] + dp[i - 1][0]  (可以买卖多次，因此需要加上之前所得到的收益，之前的肯定是已经卖出的)
        // 两者取最大值


        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0; //不持有股票，初始资金为0
        dp[0][1] = -prices[0]; //持有股票，初始资金为 0-prices[0] = -prices[0]

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }
        return dp[prices.length - 1][0]; //最后求结果的时候，肯定是不持有股票
    }
}
