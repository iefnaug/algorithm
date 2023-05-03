package com.algorithm.linkedlist;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * @author GF
 * @since 2023/5/3
 */
public class A0203RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode start = sentinel;

        while (start.next != null) {
            if (start.next.val == val) {
                start.next = start.next.next;
            } else {
                start = start.next;
            }
        }
        return sentinel.next;
    }

}
