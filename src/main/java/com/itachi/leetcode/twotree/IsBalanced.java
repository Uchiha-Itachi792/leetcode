package com.itachi.leetcode.twotree;
//110. 平衡二叉树
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int high = getHigh(root.left);
        return high != -1;
    }

    public int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //获取左子树的高度
        int left = getHigh(root.left);
        if (left == -1) {
            return -1;
        }

        //获取右子树的高度
        int right = getHigh(root.right);
        if (right == -1) {
            return -1;
        }
        //如果高度差大于1，说明不平衡，直接返回-1
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
