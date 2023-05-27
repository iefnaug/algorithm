package com.algorithm.linkedlist;

/**
 * 61. 旋转链表
 * 中等
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 *
 * @author GF
 * @since 2023/5/27
 */
public class A0061RotateList {

    public class ListNode {
      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode right = dummyNode;
        int move = count - k;
        for (int i = 0; i < move; i++) {
            right = right.next;
        }
        ListNode left = dummyNode;
        while (right.next != null) {
            ListNode record = right.next;
            right.next = record.next;
            record.next = left.next;
            left.next = record;
            left = left.next;
        }
        return dummyNode.next;
    }

}
