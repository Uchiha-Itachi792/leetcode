package com.itachi.leetcode.arrays;

public class RemoveElement {

    public static void main(String[] args) {
        String test = new RemoveElement().test("aaa");
        System.out.println("print " + test);
    }

    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            //如果不相等，快慢指针同时向前移动
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }

            //否则只移动快指针，慢指针要么指向相等元素，要么指向相等元素的下一位
        }
        return slowIndex;
    }

    public String test(String a) {
        try {
            String abc =a + "asdasda";
            System.out.println("try print");
            return abc;
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("finally print");
            //return "asdade";
        }
    }
}
