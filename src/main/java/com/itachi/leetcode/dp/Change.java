package com.itachi.leetcode.dp;

import java.util.Arrays;
//518. 零钱兑换 II
public class Change {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;

        new Change().change(amount, coins);
    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public void print(int[][] table) {
        // 遍历table这个二维数组
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
