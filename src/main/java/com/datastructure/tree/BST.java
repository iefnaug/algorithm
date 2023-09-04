package com.datastructure.tree;

/**
 * @author GF
 * @since 2023/9/2
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N; //以该结点为根的子树中的结点总数

        Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }



    /**
     * 获取总节点数
     */
    public int size() {
        return size(root);
    }

    /**
     * 获取任意子树的节点数
     *
     */
    private int size(Node node) {
        return node == null ? 0 : node.N;
    }


    //插入
    public void put(Key key, Value val) {
        if (key == null) {
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int ret = node.key.compareTo(key);;
        if (ret == 0) {
            //replace
            node.val = val;
        } else if (ret < 0) {
            node.right = put(node.right, key, val);
        } else {
            node.left = put(node.left, key, val);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    //查找
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int ret = node.key.compareTo(key);
        if (ret == 0) {
            return node.val;
        }
        if (ret < 0) {
            return get(node.right, key);
        }
        return get(node.left, key);
    }

    //获取最大Key
    public Key maxKey() {
        return root == null ? null : maxKey(root);
    }

    private Key maxKey(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.key;
    }

    //获取最小Key
    public Key minKey() {
        return root == null ? null : minKey(root);
    }

    private Key minKey(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    //向下取整
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    //查找不大于目标key的最大key
    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int ret = node.key.compareTo(key);
        if (ret == 0) {
            return node;
        } else if (ret > 0) {
            return floor(node.left, key);
        } else {
            Node t = floor(node.right, key);
            return t == null ? node : t;
        }
    }

    //查找不小于目标key的最小key
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int ret = node.key.compareTo(key);
        if (ret == 0) {
            return node;
        } else if (ret < 0) {
            return ceiling(node.right, key);
        } else {
            Node t = ceiling(node.left, key);
            return t == null ? node : t;
        }
    }

    //假设我们想找到排名为 k 的键(即树中正好有 k 个小于它的键)。
    //如果左子树中的结点数 t 大于 k， 那么我们就继续(递归地)在左子树中查找排名为 k 的键;
    //如果 t 等于 k，我们就返回根结点中的键; 如果 t 小于 k，我们就(递归地)在右子树中查找排名为(k-t-1)的键
    public Key select(int n) {
        if (root == null || root.N < n-1) {
            return null;
        }
        return select(root, n).key;
    }

    //求BST中第k大的节点的key, k >= 1, 转换为求排名为(root.N - k - 1)的节点的key
    private Node select(Node node, int n) {
        if (node == null) {
            return null;
        }
        int t = size(node.left);
        if (t == n) {
            return node;
        } else if (t > n) {
            return select(node.left, n);
        } else {
            //换成右子树，减少t+1个节点
            return select(node.right, n - t - 1);
        }
    }




    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
    }
}
