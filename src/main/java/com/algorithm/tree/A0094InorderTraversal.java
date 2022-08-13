package com.algorithm.tree;

import java.util.*;

/**
 *  中序遍历：左 -> 根 -> 右
 */
public class A0094InorderTraversal {

    /**
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> container = new LinkedList<>();
        recursion(root, container);
        return container;
    }

    private void recursion(TreeNode root, List<Integer> container) {
        if (root != null) {
            recursion(root.getLeftChild(), container);
            container.add(root.getValue());
            recursion(root.getRightChild(), container);
        }
    }


    /**
     * 迭代
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> container = new LinkedList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.getLeftChild();
            }
            root = stk.pop();
            container.add(root.getValue());
            root = root.getRightChild();
        }
        return container;
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

        A0094InorderTraversal algorithm = new A0094InorderTraversal();
        List<Integer> container = algorithm.inorderTraversal2(root);
        for (Integer integer : container) {
            System.out.println(integer);
        }

    }

}
