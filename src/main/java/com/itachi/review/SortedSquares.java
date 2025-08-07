package com.itachi.review;

public class SortedSquares {

    public void sortDemo(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] res = new int[nums.length];
        int index = nums.length - 1;
        while (left >= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index] = nums[left] * nums[left];
                index--;
                ++left;
            } else {
                res[index] = nums[right] * nums[right];
                index--;
                --right;
            }
        }
    }
}
