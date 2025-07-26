package com.itachi.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

//1. 两数之和
public class TwoSum {
    // 什么时候使用哈希法，当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                result[0] = i;
                result[1] = map.get(tmp);
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
