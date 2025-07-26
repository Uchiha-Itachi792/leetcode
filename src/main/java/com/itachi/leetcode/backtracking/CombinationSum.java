package com.itachi.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//39. 组合总和
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();


    public static void main(String[] args) {
        int[] candidates = new int[]{8, 7, 4, 3};
        new CombinationSum().combinationSum(candidates, 11);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combination(candidates, target, 0);
        return result;

    }

    public void combination(int[] candidates, int target, int start) {
        if (sum(path) == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum(path) > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            path.add(candidates[i]);
            //此处的startIndex是i+1
            //因为原始数组中的元素可以重复使用
            combination(candidates, target, i);
            //path.removeLast();
            path.remove(path.size() - 1);
        }
    }


    public int sum(ArrayList<Integer> path) {
        int sum = 0;
        for (Integer i : path) {
            sum = sum + i;
        }

        return sum;
    }


    public List<List<Integer>> combinationSumOtherVersion(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }

}
