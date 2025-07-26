package com.itachi.leetcode.twotree;
//101. 对称二叉树

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    //采用后序遍历的方式
    //因此你需要优先比较左和右的节点情况
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }


        boolean compare1 = compare(left.left, right.right);
        boolean compare2 = compare(left.right, right.left);

        return compare1 && compare2;
    }
}
