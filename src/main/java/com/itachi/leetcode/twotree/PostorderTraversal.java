package com.itachi.leetcode.twotree;

import java.util.ArrayList;
import java.util.List;
//145.二叉树的后序遍历
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;

    }

    //左->右->要处理的节点
    public void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}
