package com.itachi.leetcode.dp;

import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 5, 3, 7, 101, 18};
        new LengthOfLIS().lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        //从任意位置开始，但以nums【i】元素作为结尾的所有 递增子序列中，最长的子序列长度为 dp【i】
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                // 先把dp[j]+1赋值给dp[i],但j的范围是0-i
                // 所以此处对j进行遍历
                // 要取所有dp[j]+1里面最大的那个做为dp[i]的值

                if (nums[i] > nums[j]) {
                    //注意这里不是要dp[i] 与 dp[j] + 1进行比较，而是我们要取dp[j] + 1的最大值。
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
