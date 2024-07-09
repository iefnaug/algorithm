package com.a2024.tree;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class A0095 {

    public List<TreeNode> numTrees(int n) {
        if (n <= 0) {
            return new LinkedList<>();
        }
        return dfs(1, n);
    }

    /**
     * 二叉搜索树的性质: 左 < 根 < 右
     */
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> all = new LinkedList<>();
        if (start > end) {
            all.add(null);
            return all;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = dfs(start, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    all.add(root);
                }
            }
        }
        return all;
    }


}
