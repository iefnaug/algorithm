package com.algorithm.tree;

/**
 * @author GF
 * @since 2023/8/26
 */
public class A0098ValidateBST {

    public class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (val > min && val < max) {
            return isValidBST(node.left, min, val) && isValidBST(node.right, val, max);
        } else {
            return false;
        }
    }


}
