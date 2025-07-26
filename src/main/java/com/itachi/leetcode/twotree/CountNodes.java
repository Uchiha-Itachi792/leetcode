package com.itachi.leetcode.twotree;

import java.util.Deque;
import java.util.LinkedList;

public class CountNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int i = countNodes(root, 0);
        System.out.println("");


    }


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        int num = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = nodes.pop();
                if (first.left != null) {
                    nodes.add(first.left);
                }
                if (first.right != null) {
                    nodes.add(first.right);
                }
                num++;
            }
        }
        return num;
    }


    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes2(root.left);
        int right = countNodes2(root.right);
        return left + right + 1;
    }

    public static int countNodes(TreeNode root, int num) {
        if (root == null) {
            return num;
        }
        num = num + 1;
        countNodes(root.left, num);
        countNodes(root.right, num);
        return num;
    }
}
