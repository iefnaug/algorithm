package com.algorithm.linkedlist;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @author GF
 * @since 2022/4/3
 */
public class A0876MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0, head);
        ListNode slow = sentinel;
        ListNode fast = sentinel;
        for(;;) {
            if (fast.next == null) {
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                return slow;
            }
        }
    }

}
