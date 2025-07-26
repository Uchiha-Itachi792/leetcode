package com.itachi.leetcode.twotree;


//104. 二叉树的最大深度

public class MaxDepth {


    /**
     * 高度：任意节点到 叶子节点  的距离
     * 深度：任意节点到 根节点   的距离
     * 根节点的高度就是二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //当前节点的高度，是左子树和右子树的高度的最大值再+1.
        // +1是为了把自己这一层加上
        int hight = Math.max(left, right) + 1;
        return hight;
    }
}
