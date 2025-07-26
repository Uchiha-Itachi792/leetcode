package com.itachi.leetcode.dp;

import java.util.HashMap;

//70. 爬楼梯
public class ClimbStairs {

    /**
     * 第n阶台阶 = 第 n-1阶台阶 + 迈一步
     * 第n阶台阶 = 第 n-2阶台阶 + 迈两步
     *
     * 比如：要想跳到第10级台阶，如果最后一步是跳1级，则前面必须跳到第9级，而跳到第9级有f(9)种解法；
     * 如果最后一步是跳2级，则前面比如跳到第8级有f(8)种解法。由于最后一步是不一样的，所以[f(9),1]和[f(8),2]是互不相同的跳法，一共有f(10)=f(9)+f(8)种跳法
     * 推到出公式：F(N) = F(N-1) + F(N-2)
     * @param n
     * @return
     */

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int index = 3; index <= n; index++){
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }
}
