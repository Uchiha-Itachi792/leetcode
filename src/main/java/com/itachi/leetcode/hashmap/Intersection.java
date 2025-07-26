package com.itachi.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//349. 两个数组的交集
public class Intersection {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();
        for (int x : nums1) {
            st.add(x);
        }

        List<Integer> lst = new ArrayList<>();
        for (int x : nums2) {
            //remove方法，存在就删除该元素。
            //通过这种方式保证下一个重复元素不会添加进数组中
            if (st.remove(x)) {
                lst.add(x);
            }
        }

        // 由于返回值是 int[]，需要额外遍历一次
        int[] ans = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ans[i] = lst.get(i);
        }
        return ans;

    }
}
