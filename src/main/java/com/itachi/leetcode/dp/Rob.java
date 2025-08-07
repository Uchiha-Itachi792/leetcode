package com.itachi.leetcode.dp;

//198. 打家劫舍
public class Rob {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(" ");
    }


    public int rob(int[] nums) {
        //dp[i] : 0~i的房间中，打家劫舍的最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //放i，那么值=dp[i-2]+dp[i]
        //不放i，那么值= dp[i-1]
        //两者取最大值
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }


}
