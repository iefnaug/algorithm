package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GF
 * @since 2023/8/26
 */
public class A0173BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<TreeNode> list = new ArrayList<>();

    private int index = 0;

    public A0173BSTIterator(TreeNode root) {
        inorder(root, list);
    }

    private void inorder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    public int next() {
        return list.get(index++).val;
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;


        A0173BSTIterator algorithm = new A0173BSTIterator(node4);
        while (algorithm.hasNext()) {
            System.out.println(algorithm.next());
        }
    }

}
