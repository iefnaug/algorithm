package com.algorithm.linkedlist;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * @author GF
 * @since 2022/4/3
 */
public class A0019RemoveNthNodeFromEndOfList3 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode slow = sentinel, fast = sentinel;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode removed = slow.next;
        slow.next = removed.next;
        removed.next = null;
        return sentinel.next;
    }
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        A0019RemoveNthNodeFromEndOfList3 removeNthNodeFromEndOfList = new A0019RemoveNthNodeFromEndOfList3();
        final ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(n1, 2);
        System.out.println();

    }

}
