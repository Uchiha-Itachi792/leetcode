package com.itachi.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public static void main(String[] args) {

    }

    /**
     * points = [[1,6],[2,8],[7,12],[10,16]] 的结构如下所示：
     *       0    1
     *  0    1,   6
     *  1    2,   8
     *  2    7,   12
     *  3    10,  16
     *  如果一个气球的做左边界[i][0]大于上一个元素的右边界[i-1][1]，说明不重叠，需要一个气球
     *
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int count = 1;  // points 不为空至少需要一支箭
        for (int i = 1; i < points.length; i++) {
            // 气球i和气球i-1不挨着，注意这里不是>=
            // 如果相等的话，也可以一支箭射爆，不需要count++
            if (points[i][0] > points[i - 1][1]) {
                count++; // 需要一支箭
            } else {
                // 气球i和气球i-1挨着
                // 更新重叠气球最小右边界，这样就可以判断下下个气球是否也挨着
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
