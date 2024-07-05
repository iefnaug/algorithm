package com.a2024.tree;

import com.entity.TreeNode;
import com.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class A0094 {

    /**
     * 中序遍历：左 -> 根 -> 右
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        helper(root, resultList);
        return resultList;
    }

    private void helper(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        helper(root.getLeftChild(), resultList);
        resultList.add(root.getValue());
        helper(root.getRightChild(), resultList);
    }


    public static void main(String[] args) {
        List<Integer> nodeList = Stream.of(1, 2, 3, 4, 5, 6, 7).collect(Collectors.toList());
        TreeNode root = TreeUtils.generateTree(nodeList);
        A0094 algorithm = new A0094();
        List<Integer> nodes = algorithm.inorderTraversal(root);
        nodes.forEach(System.out::println);

    }

}
