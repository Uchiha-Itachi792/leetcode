package com.itachi.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法，一般可以解决如下几种问题：
 *
 * 组合问题：N个数里面按一定规则找出k个数的集合
 * 切割问题：一个字符串按一定规则有几种切割方式
 * 子集问题：一个N个数的集合里有多少符合条件的子集
 * 排列问题：N个数按一定规则全排列，有几种排列方式
 * 棋盘问题：N皇后，解数独等等
 *
 * 什么是组合，什么是排列？组合是不强调元素顺序的，排列是强调元素顺序.例如：{1, 2} 和 {2, 1} 在组合上，就是一个集合，因为不强调顺序，而要是排列的话，{1, 2} 和 {2, 1} 就是两个集合了。
 * 如果是一个集合来求组合的话，就需要startIndex
 * 如果是多个集合取组合，各个集合之间相互不影响，那么就不用startIndex
 */



//77. 组合
public class Combine {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Combine combine = new Combine();

        List<List<Integer>> combine1 = combine.combine(4, 2);
        System.out.println(" ");
    }


    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
