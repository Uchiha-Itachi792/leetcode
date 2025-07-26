package com.itachi.leetcode.greedy;

import java.util.Arrays;
//455. 分发饼干
public class FindContentChildren {

    /**
     * 贪心算法：每次满足最大胃口的孩子
     *
     * @param g 小孩的胃口数组
     * @param s 饼干数组
     * @return 最大能够满足的孩子树
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sIndex = s.length - 1;

        int count = 0;

        for (int i = g.length - 1; i >= 0; i--) {
            if (sIndex > 0 && g[i] <= s[sIndex]) {
                sIndex--;
                count++;
            }
        }
        return count;
    }
}
