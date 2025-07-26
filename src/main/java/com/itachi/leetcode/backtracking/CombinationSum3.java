package com.itachi.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//216. 组合总和 III
public class CombinationSum3 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSum3().combinationSum3(3, 9);
        System.out.println(" ");
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        combine(k, n, 1);
        return result;
    }


    public void combine(int k, int n, int start) {
        if (path.size() == k && sum(path) == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            //此处的startIndex是i+1
            //因为原始数组中的元素不能重复使用
            combine(k, n, i + 1);
            path.removeLast();
        }
    }

    public int sum(LinkedList<Integer> path) {
        int sum = 0;
        for (Integer i : path) {
            sum = sum + i;
        }

        return sum;
    }
}
