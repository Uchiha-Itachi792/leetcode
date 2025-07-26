package com.itachi.leetcode.arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        search(nums, 9);


    }

    /**
     * 第一种写法，我们定义 target 是在一个在左闭右闭的区间里，也就是[left, right] （这个很重要非常重要）。区间的定义这就决定了二分法的代码应该如何写，因为定义target在[left, right]区间，所以有如下两点：
     * 1.while (left <= right) 要使用 <=
     *   因为left == right是有意义的，比如[1,1]这样的区间是一个合法区间，所以使用 <=
     * 2.if (nums[middle] > target) right 要赋值为 middle - 1
     * 因为我们使用的是一个左闭右闭区间，因此判断的时候，会对nums[middle]进行判断。
     * 由于当前这个nums[middle]一定不是target，那么接下来要查找的区间的右边界位置就是 middle -1
     */
    public static int search(int[] nums, int target) {

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }


        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
