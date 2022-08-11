package com.algorithm.linkedlist;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class A0024SwapNodes {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode tmp = dummyNode;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode cur = tmp.next;
            ListNode next = tmp.next.next;
            cur.next = next.next;
            next.next = cur;
            tmp.next = next;
            tmp = tmp.next.next;
        }
        return dummyNode.next;
    }

}
