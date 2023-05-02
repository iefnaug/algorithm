package com.algorithm.linkedlist;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * @author GF
 * @since 2023/5/3
 */
public class A0019RemoveNthNodeFromEndOfList2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
//        ListNode n5 = new ListNode(5, null);
//        ListNode n4 = new ListNode(4, n5);
//        ListNode n3 = new ListNode(3, n4);
//        ListNode n2 = new ListNode(2, n3);
//        ListNode n1 = new ListNode(1, n2);
        ListNode n1 = new ListNode(1, null);

        A0019RemoveNthNodeFromEndOfList2 removeNthNodeFromEndOfList = new A0019RemoveNthNodeFromEndOfList2();
        final ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(n1, 1);
        System.out.println();

    }

}
