package com.algorithm.linkedlist;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * @author GF
 * @since 2022/4/3
 */
public class A0019RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        ListNode sentinel = new ListNode(0, head);
        ListNode slow = sentinel;
        ListNode fast = sentinel;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        for (;;) {
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            } else {
                break;
            }
        }
        slow.next = slow.next.next;
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        A0019RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new A0019RemoveNthNodeFromEndOfList();
        final ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(n1, 2);
        System.out.println();

    }

}
