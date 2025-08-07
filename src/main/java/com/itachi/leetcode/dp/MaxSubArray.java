package com.itachi.leetcode.dp;

//53. 最大子数组和
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        new MaxSubArray().maxSubArray(nums);
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //情况1：利用前面的子序列继续计算
            //情况2：不要前面的子序列了，从nums[i]重新开始计算
            dp[i] = Math.max(dp[i - 1] + nums[i],  nums[i]);
        }
        return 0;
    }
}
