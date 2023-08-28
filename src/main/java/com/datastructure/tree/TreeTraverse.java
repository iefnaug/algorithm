package com.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的各种遍历方式
 * @author GF
 * @since 2023/8/28
 */
public class TreeTraverse {

    /**
     * 前序遍历 => 根 左 右
     */
    public static void preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.getVal());
        preOrder(root.getLeft(), ans);
        preOrder(root.getRight(), ans);
    }

    /**
     * 后序遍历 => 左 右 根
     */
    public static void postOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft(), ans);
        postOrder(root.getRight(), ans);
        ans.add(root.getVal());
    }

    /**
     * 中序遍历 => 左 根 右
     */
    public static void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), ans);
        ans.add(root.getVal());
        inOrder(root.getRight(), ans);
    }

    /**
     * 层序遍历
     */
    public static void levelOrder(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                list.add(node.getVal());
                TreeNode left = node.getLeft();
                TreeNode right = node.getRight();
                if (left != null) {
                    newQueue.offer(left);
                }
                if (right != null) {
                    newQueue.offer(right);
                }
            }
            ans.add(list);
            queue.addAll(newQueue);
        }
    }

    /**
     * 生成二叉树
     */
    public static TreeNode generateTree(Integer[] nums) {
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != null) {
                nodes[i] = new TreeNode(nums[i]);
            }
        }

        int len = nodes.length;
        for (int i = 0; i < len; i++) {
            if (nodes[i] == null) {
                continue;
            }
            int left = i * 2 + 1, right = i * 2 + 2;
            if (left < len) {
                nodes[i].setLeft(nodes[left]);
            } else {
                break;
            }
            if (right < len) {
                nodes[i].setRight(nodes[right]);
            }
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        Integer[] nums = {4,2,6,1,3,5,7};
        TreeNode root = generateTree(nums);

        List<Integer> ans = new ArrayList<>();
//        preOrder(root, ans);
//        inOrder(root, ans);
        postOrder(root, ans);
        ans.forEach(System.out::println);

//        List<List<Integer>> ans = new ArrayList<>();
//        levelOrder(root, ans);
//        for (List<Integer> list : ans) {
//            list.forEach(a -> System.out.print(a + ", "));
//            System.out.println();
//        }
    }

}
