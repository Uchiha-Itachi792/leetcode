package com.itachi.leetcode.twoPoint;

public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        maxArea(height);

    }

    /**
     * 数组中元素的值在坐标轴上是y，对应的下标在坐标轴上是x，那么最大面积 = y * x。
     * 假设当前左指针和右指针指向的数分别为 a 和 b，两个指针之间的距离为 t，并且假设 a <b，那么 最大面积 = min(a,b) * t
     * 在此种情况下，只能移动左指针，因为不管右指针如何移动，后续计算的最大面积始终 <= a* t
     */

    public static int maxArea(int[] height) {
        int length = height.length;
        int right = length - 1;
        int left = 0;


        int max = 0;
        while (left < right) {

            if (Math.min(height[left], height[right]) * (right - left) > max) {
                max = Math.min(height[left], height[right]) * (right - left);
            }

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
