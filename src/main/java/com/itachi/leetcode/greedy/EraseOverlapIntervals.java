package com.itachi.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {



    public static void main(String[] args) {
        int[][] nums = new int[][] {{1,2},{1,3},{2,3},{3,4}};
        new EraseOverlapIntervals().eraseOverlapIntervals(nums);
    }


    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return count;
    }
}
