package com.utils;

import com.entity.TreeNode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @since 2024/7/4
 */
public class TreeUtils {


    public static TreeNode generateTree(List<Integer> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return null;
        }
        List<TreeNode> treeNodeList =
                nodeList.stream().map(TreeNode::new).collect(Collectors.toList());
        int len = treeNodeList.size();
        for (int i = 0; i < len; i++) {
            TreeNode treeNode = treeNodeList.get(i);
            int leftIndex = i * 2 + 1, rightIndex = i * 2 + 2;
            if (leftIndex < len) {
                treeNode.setLeftChild(treeNodeList.get(leftIndex));
            }
            if (rightIndex < len) {
                treeNode.setRightChild(treeNodeList.get(rightIndex));
            }
        }
        return treeNodeList.get(0);
    }

}
