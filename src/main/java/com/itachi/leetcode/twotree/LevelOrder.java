package com.itachi.leetcode.twotree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102.二叉树的层序遍历
public class LevelOrder {

    public static void main(String[] args) {
        Integer a = 129;
        Integer b = 129;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //思路就是某个节点出队的时候，就将这个节点的左右节点入队
            //队列中很有可能存在该层节点和下一层的节点
            //通过size控制出列的个数，同一层节点的个数 =  size.
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }

                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            result.add(list);
        }
        return result;

    }
}
