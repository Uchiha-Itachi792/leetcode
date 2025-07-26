package com.itachi.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//46. 全排列
public class Permute {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    boolean[] used; //标记元素是否使用


//    public static void main(String[] args) {
//        int nums[] = new int[]{1, 2, 3};
//        new Permute().permute(nums);
//    }

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        permuteFunc(nums);
        return res;
    }

    //排序问题可以取重复数据，所以不需要startIndex
    public void permuteFunc(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                permuteFunc(nums);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
