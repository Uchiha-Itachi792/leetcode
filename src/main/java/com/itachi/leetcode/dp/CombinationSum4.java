package com.itachi.leetcode.dp;

import java.util.Arrays;
//377. 组合总和 Ⅳ
public class CombinationSum4 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        new CombinationSum4().combinationSum4(nums, target);
    }


    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}
