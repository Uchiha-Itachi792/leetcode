package com.itachi.leetcode.twotree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//144.二叉树的前序遍历
//
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    //要处理的节点->左->右
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            list.add(top.val); //中
            if (top.right != null){
                stack.push(top.right); //左
            }
            if (top.left != null){
                stack.push(top.left); //右
            }
        }
        return list;
    }
}
