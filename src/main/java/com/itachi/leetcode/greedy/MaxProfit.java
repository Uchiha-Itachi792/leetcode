package com.itachi.leetcode.greedy;
//122. 买卖股票的最佳时机 II
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}
