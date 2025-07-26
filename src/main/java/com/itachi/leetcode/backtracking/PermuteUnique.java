package com.itachi.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    boolean[] used;

//    public static void main(String[] args) {
//        int nums[] = new int[]{1, 1, 3};
//        new PermuteUnique().permuteUnique(nums);
//    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        permuteUniqueFunc(nums);
        return res;
    }

    public void permuteUniqueFunc(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                permuteUniqueFunc(nums);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
