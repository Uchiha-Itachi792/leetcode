package com.itachi.leetcode.arrays;

//977. 有序数组的平方
public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        sortedSquares(nums);

    }

    /**
     * 由于数组是非递减排序，那么最大值的产生只能是数组的两端
     * 因此只需要定义双指针，每次比较数组的两端即可，将最大值放置新数组的最末端
     * 若左边大于右边，那么再移动左边的指针
     */
    public static int[] sortedSquares(int[] nums) {
        int[] resultsArray = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        int index = nums.length - 1; //用于resultsArray的index变量
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                resultsArray[index--] = nums[left] * nums[left];
                ++left;
            } else {
                resultsArray[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return resultsArray;
    }
}
