package com.itachi.leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
        new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");

    }

    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hs = new HashMap<>(); //一个hashMap 来统计字母的最远出现位置
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hs.put(c, i);
        }

        List<Integer> ans = new ArrayList<>();   //存放结果
        int lastIndex = -1;  //从-1开始 因为下标从0开始 len=i-lastIndex
        int cover = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cover = Math.max(cover, hs.get(c)); //更新当前字符串的中的字母最远出现位置
            if (cover == i) {  //如果已经是最远出现位置;则找到加入结果集
                ans.add(i - lastIndex);
                lastIndex = i; //重新开始找，所以lastIndex为起点开始往后找
            }
        }
        return ans;
    }
}
