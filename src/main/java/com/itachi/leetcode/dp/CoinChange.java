package com.itachi.leetcode.dp;
//322. 零钱兑换
public class CoinChange {

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        int count = 3;

        System.out.println(Integer.MAX_VALUE + 1);
        new CoinChange().coinChange(nums, count);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
