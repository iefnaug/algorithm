package com.algorithm.tree;

/**
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @author GF
 * @since 2023/7/23
 */
public class A0101SymmetricTree {

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

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && compare(left.left, right.right) && compare(left.right, right.left);
    }

}
