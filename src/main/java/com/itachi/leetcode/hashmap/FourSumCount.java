package com.itachi.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;
//454. 四数相加 II
public class FourSumCount {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, -1};
        int[] nums2 = new int[]{-1, 1};
        int[] nums3 = new int[]{-1, 1};
        int[] nums4 = new int[]{1, -1};

        fourSumCount(nums1, nums2, nums3, nums4);

    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (map.containsKey(sum)) {
                    Integer value = map.get(sum); //sum出现的次数
                    map.put(sum, value + 1);
                } else {
                    map.put(sum, 1);
                }

            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                int gap = 0 - i - j;
                if (map.containsKey(gap)) {
                    res = res + map.get(gap);
                }
            }
        }
        return res;
    }


    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
}
