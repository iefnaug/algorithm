package com.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 *
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。
 *
 * @author GF
 * @since 2023/5/27
 */
public class A0138CopyList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node headCopy = new Node(head.val);

        Node headPointer = head;
        Node headCopyPointer = headCopy;

        while (headPointer.next != null) {
            headCopyPointer.next = new Node(headPointer.next.val);
            headCopyPointer = headCopyPointer.next;
            headPointer = headPointer.next;
        }

        headPointer = head;
        headCopyPointer = headCopy;

        while (headPointer != null) {
            if (headPointer.random == null) {
                headCopyPointer.random = null;
            } else {
                Node countNode = head;
                int count = 0;
                while (countNode != headPointer.random) {
                    countNode = countNode.next;
                    count++;
                }
                Node nodeCopy = headCopy;
                for (int i = 0; i < count; i++) {
                    nodeCopy = nodeCopy.next;
                }
                headCopyPointer.random = nodeCopy;
            }
            headPointer = headPointer.next;
            headCopyPointer = headCopyPointer.next;
        }
        return headCopy;
    }


    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }


    /**
     * 将该链表中每一个节点拆分为两个相连的节点
     */
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }


}
