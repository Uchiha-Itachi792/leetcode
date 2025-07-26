package com.itachi.leetcode.arrays;

//59. 螺旋矩阵 II
public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] nums = new int[10][20];

        System.out.println(nums.length);
    }

    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        // startX和startY每一圈的起始点
        int startX = 0;
        int startY = 0;
        int offset = 1; // 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        int count = 1;  // 矩阵中需要填写的数字
        int loop = 1; // 记录当前的圈数
        int i; // i 代表行
        int j; // j 代表列

        while (loop <= n / 2) {

            // 顶部,列从第startX=0列开始，行为startY
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startX; j < n - offset; j++) {
                nums[startY][j] = count++;
            }

            // 右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startY; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左列
            // 左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;

    }
}
