package com.algorithm.linkedlist;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class A0206ReverseLinkedList2 {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        ListNode cursor = head;
        while (cursor != null) {
            ListNode node = cursor;
            cursor = cursor.next;
            node.next = dummyNode.next;
            dummyNode.next = node;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        A0206ReverseLinkedList2 linkedList = new A0206ReverseLinkedList2();
        ListNode listNode = linkedList.reverseList(n1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}



