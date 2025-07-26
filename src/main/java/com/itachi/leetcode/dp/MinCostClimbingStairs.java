package com.itachi.leetcode.dp;

public class MinCostClimbingStairs {

    /**
     * 若cost[]数组为null，那么dp[0] =0 ；
     *  cost[10],也就是 cost[0] = 10 ->dp[1] = dp[0] + cost[0] 或 dp[1] = 0. 因为第一次可以选择从台阶1处开始
     *  cost[10,15],也就是 cost[1] = 15 ->dp[2] = dp[1] + cost[1] 或 dp[2] = dp[0] + cost[0]
     *  推导公式：dp[i] = dp[i-1] + cost[i-1] 或者dp[i] = dp[i-2] + cost[i-2]. 从中间取最小值
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];

        // 从下标为 0 或下标为 1 的台阶开始，因此支付费用为0
        dp[0] = 0;
        dp[1] = 0;

        // 计算到达每一层台阶的最小费用
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[len];
    }
}
