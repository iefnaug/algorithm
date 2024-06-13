package com.a2024.linkedlist;

import com.entity.ListNode;
import com.utils.NodeUtils;

/**
 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

 * @author gf01867832
 * @since 2024/6/13
 */
public class A0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode left = sentinel, right = sentinel;
        for (int i = 0; i < n; i++) {
            right = right.next;
            if (right == null) {
                return head;
            }
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        ListNode node = left.next;
        left.next = node.next;
        node.next = null;
        return sentinel.next;
    }


    public static void main(String[] args) {
        A0019 algorithm = new A0019();
        ListNode listNode = NodeUtils.buildList("1,2,3,4,5,6,7,8");
        ListNode head = algorithm.removeNthFromEnd(listNode, 4);
        NodeUtils.print(head);
    }

}
