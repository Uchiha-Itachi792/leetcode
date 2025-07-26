package com.itachi.leetcode.twotree;

public class SearchBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        TreeNode treeNode = searchBST(root, 2);

        System.out.println(" ");
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
           return searchBST(root.left, val);
        } else {
            return  searchBST(root.right, val);
        }
    }
}
