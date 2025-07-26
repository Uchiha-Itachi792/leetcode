package com.itachi.leetcode.dp;
//343. 整数拆分
public class IntegerBreak {
    public int integerBreak(int n) {
        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            // 其实这里的 j 其实最大值应该为 i-j,再大只不过是重复而已，
            for(int j = 1; j <= i; j++) {
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
                //加上dp[i]的原因：我们会尝试不同的j值进行拆分，在一个j值拆分的时候，根据上面介绍的两种情况取最大(Math.max(j*(i-j), j*dp[i-j]))
                // 那么如果我们换下一个j的时候，就和当前的dp[i]比较，相当于取不同j下面的最大值
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
