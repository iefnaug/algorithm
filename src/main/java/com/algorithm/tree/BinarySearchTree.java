package com.algorithm.tree;

import java.util.LinkedList;

/*
 * @author GF
 * @since 2022/5/12
 */
public class BinarySearchTree {

    /**
     * 前序遍历:  根 左 右
     */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getValue() + ", ");
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }


    /**
     * 中序遍历：左 根 右
     */
    public static void middleOrder(TreeNode root) {
        if (root != null) {
            middleOrder(root.getLeftChild());
            System.out.print(root.getValue() + ", ");
            middleOrder(root.getRightChild());
        }
    }


    /**
     * 后序遍历：左 右 根
     */
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.getLeftChild());
            postOrder(root.getRightChild());
            System.out.print(root.getValue() + ", ");
        }
    }


    /**
     * 广度优先遍历|层序遍历
     */
    public static void rangOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            final TreeNode treeNode = list.removeFirst();
            if (treeNode != null) {
                System.out.print(treeNode.getValue() + ", ");
                if (treeNode.getLeftChild() != null) {
                    list.add(treeNode.getLeftChild());
                }
                if (treeNode.getRightChild() != null) {
                    list.add(treeNode.getRightChild());
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        root.setLeftChild(n1);
        root.setRightChild(n2);

        n1.setLeftChild(n3);
        n1.setRightChild(n4);

        n2.setLeftChild(n5);
        n2.setRightChild(n6);

        preOrder(root);
        System.out.println();
        middleOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        rangOrder(root);

    }

}
