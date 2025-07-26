package com.itachi.leetcode.twotree;


//111. 二叉树的最小深度


public class MinDepth {
    //注意：
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //左字典不存在，右节点存在的情况
        if (root.left == null && root.right != null) {
            return 1 + right;
        }

        if (root.right == null && root.left != null) {
            return 1 + left;
        }
        return Math.min(left, right) + 1;
    }
}
