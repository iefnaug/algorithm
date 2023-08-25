package com.datastructure.search;

/**
 * 二分查找树
 * @author GF
 * @since 2023/8/15
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int n; //以该结点为根的子树中的结点总数

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    /**
     * 获取节点个数
     */
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.n;
    }

    /**
     * 查找
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node root, Key key) {
       if (root == null) {
           return null;
       }
       int result = key.compareTo(root.key);
       if (result == 0) {
           return root.value;
       } else if (result < 0) {
           return get(root.left, key);
       } else {
           return get(root.right, key);
       }
    }

    /**
     * 设置
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }


    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int result = key.compareTo(node.key);
        if (result < 0) {
            node.left = put(node.left, key, value);
        } else if (result > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 获取key最小节点
     */
    public Node min() {
        return min(root);
    }

    private Node min(Node root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    /**
     * 获取key最大节点
     */
    public Node max() {
        return max(root);
    }

    private Node max(Node root) {
        if (root.right == null) {
            return root;
        }
        return max(root.right);
    }



}
