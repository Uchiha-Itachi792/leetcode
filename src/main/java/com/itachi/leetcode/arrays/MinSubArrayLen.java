package com.itachi.leetcode.arrays;

//209. 长度最小的子数组
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        minSubArrayLen(7, nums);

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int gap = Integer.MAX_VALUE;
        int sum = 0;
        //外层控制right指针
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            //while循环控制left指针
            while ( sum >= target) {
                gap = Math.min(gap, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return gap == Integer.MAX_VALUE ? 0 : gap;
    }
}
