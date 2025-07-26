package com.itachi.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//78. 子集
public class Subsets {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(nums, 0, res, path);
        return res;
    }

    public void backTrack(int[] nums, int startIndex, List<List<Integer>> res, LinkedList<Integer> path) {

        res.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length - 1; i++) {
            path.add(nums[i]);
            backTrack(nums, i+1, res, path);
            path.removeLast();
        }

    }
}
