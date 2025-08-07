package com.itachi.leetcode.dp;

import com.itachi.leetcode.twotree.TreeNode;
//337. 打家劫舍 III
public class Rob3 {

    public int rob(TreeNode root) {
        int[] res = robFunc(root);

        //比较根节点偷与不偷的最大值
        return Math.max(res[0], res[1]);
    }

    //一位动态数组dp，只需要两位即可：
    //index = 0代表不偷当前节点，dp[0]的值代表不偷当前节点的最大值
    //index = 1代表偷当前节点，  dp[1]的值代表偷当前节点的最大值
    public int[] robFunc(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) {
            return dp;
        }

        int[] left = robFunc(root.left);
        int[] right = robFunc(root.right);

        //不偷当前节点，那么就需要：
        //比较偷左节点和不偷左节点，两者比较取最大值
        //比较偷右节点和不偷右节点，两者比较取最大值
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷当前节点，那么当前节点的左右节点就不能偷了
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}
