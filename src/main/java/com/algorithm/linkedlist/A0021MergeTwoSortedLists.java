package com.algorithm.linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class A0021MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0, null);
        ListNode pointer = head;
        while (true) {
            if (list1 == null) {
                pointer.next = list2;
                break;
            } else if (list2 == null) {
                pointer.next = list1;
                break;
            } else {
                if (list1.val <= list2.val) {
                    pointer.next = list1;
                    pointer = list1;
                    list1 = list1.next;
                } else {
                    pointer.next = list2;
                    pointer = list2;
                    list2 = list2.next;
                }
            }
        }
        return head.next;
    }

}
