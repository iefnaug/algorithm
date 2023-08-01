package com.algorithm.tree;

/**
 * 提示：
 *
 * 1 <= nums.length <= 10^4
 * -104 <= nums[i] <= 10^4
 * nums 按 严格递增 顺序排列
 *
 * @author GF
 * @since 2023/8/1
 */
public class A0108ConvertSortedArrayToBinarySearchTree {

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


    public TreeNode sortedArrayToBST(int[] nums) {
        return findNode(nums, 0, nums.length - 1);
    }

    private TreeNode findNode(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int pos = (left + right) >>> 1;
        TreeNode root = new TreeNode(nums[pos]);
        root.left = findNode(nums, left, pos - 1);
        root.right = findNode(nums, pos + 1, right);
        return root;
    }

}
