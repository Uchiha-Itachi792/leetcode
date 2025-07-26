package com.itachi.leetcode.dp;

//简单来说就是任意选i块石头，使得他们的重量趋近于总重量的一半，因为这样和另一半抵消的差值就是最小的
//1049. 最后一块石头的重量 II
public class LastStoneWeightII {
    public static void main(String[] args) {
        //int[] nums = new int[]{1, 2, 3, 6};
        int[] nums = new int[]{2,7,4,1,8,1};
        int i = new LastStoneWeightII().lastStoneWeightII(nums);
        System.out.println(i);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum = sum + i;
        }
        int result = sum / 2;
        //dp[i][j] ： 从0~i中任意选取石头，放进容量为j的背包中，产生的最大价值
        //此处的最大价值就是石头的重量
        int[][] dp = new int[stones.length][result + 1];
        for (int j = stones[0]; j <= result; j++) {
            dp[0][j] = stones[0];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j <= result; j++) { //注意此处是等于
                if (stones[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        return (sum - dp[stones.length - 1][result]) - dp[stones.length - 1][result];
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
