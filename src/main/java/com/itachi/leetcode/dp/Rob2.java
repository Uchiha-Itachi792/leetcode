package com.itachi.leetcode.dp;
//213. 打家劫舍 II
public class Rob2 {
    public int rob2(int[] nums) {
        int rob1 = rob(nums, 0, nums.length - 2);
        int rob2 = rob(nums, 1, nums.length - 1);
        return Math.max(rob1, rob2);
    }

    public int rob(int[] nums, int start, int end) {
        if (end == start) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
