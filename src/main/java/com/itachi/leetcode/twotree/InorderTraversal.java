package com.itachi.leetcode.twotree;

import java.util.ArrayList;
import java.util.List;

//94.二叉树的中序遍历
public class InorderTraversal {

    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;

    }
    //左->要处理的节点->右
    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);

    }
}
