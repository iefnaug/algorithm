package com.algorithm.tree;

import java.util.*;

/**
 * @author GF
 * @since 2023/8/1
 */
public class A0102BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<TreeNode> levelList = new ArrayList<>();
        levelList.add(root);
        while (levelList.size() > 0) {
            List<Integer> valList = new ArrayList<>();
            List<TreeNode> nodeList = new ArrayList<>();
            levelList.forEach(node -> {
                valList.add(node.val);
                if (node.left != null) {
                    nodeList.add(node);
                }
                if (node.right != null) {
                    nodeList.add(node);
                }
            });
            resultList.add(valList);
            levelList = nodeList;
        }
        return resultList;
    }

    /**
     * 使用队列，减少内存占用
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> valList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    valList.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            resultList.add(valList);
        }
        return resultList;
    }

}
