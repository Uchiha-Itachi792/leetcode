package com.itachi.leetcode.twotree;

//404. 左叶子之和
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        new SumOfLeftLeaves().sumOfLeftLeaves(root);


    }
    public int sumOfLeftLeaves(TreeNode root) {

        int i = sumTotal(root);
        System.out.println(i);
        return i;
    }

    public int sumTotal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumTotal(root.left);
        int right = sumTotal(root.right);
        int sum = left + right;
        //注意一定要是叶子节点！！
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = sum + root.left.val;
        }
        return sum;
    }
}
