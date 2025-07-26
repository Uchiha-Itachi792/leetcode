package com.itachi.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

//滑动窗口模板
//外层循环扩展右边界，内层循环扩展左边界
// for (int l = 0, r = 0 ; r < n ; r++) {
//        //当前考虑的元素
//        while (l <= r && check()) {//区间[left,right]不符合题意
//        //扩展左边界
//        }
//        //区间[left,right]符合题意，统计相关信息
//
//}

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        //滑动窗口
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();//去重
        int len = chars.length;

        int left = 0;
        int result = -1;

        for (int right = 0; right < len; right++) {
            //包含相同字符的时候，那么就需要移动左指针
            while (left <= right && set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            //可能存在多个无重复字符的最长子串，因此需要比较取最大值
            result = Math.max(result, right - left + 1);
        }
        System.out.println(result);
        return result;
    }
}
