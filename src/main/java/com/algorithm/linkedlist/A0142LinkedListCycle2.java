package com.algorithm.linkedlist;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class A0142LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            if (slow == null) {
                return null;
            }
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
        } while (slow != fast);

        ListNode flag = head;
        for(;;) {
            if (fast == head) {
                return head;
            }
            head = head.next;
            fast = fast.next;
            if (flag == head) {
                return head;
            }
        }
    }

    public static void main(String[] args) {

//        ListNode n1 = new ListNode(3);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(0);
//        ListNode n4 = new ListNode(-4);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n2;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;

        A0142LinkedListCycle2 algorithm = new A0142LinkedListCycle2();
        ListNode listNode = algorithm.detectCycle(n1);
        System.out.println(listNode);
    }

}
