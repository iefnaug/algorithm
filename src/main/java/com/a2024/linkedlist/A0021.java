package com.a2024.linkedlist;

import com.entity.ListNode;
import com.utils.NodeUtils;

/**
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class A0021 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode pointer = dummyNode;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    pointer.next = list1;
                    list1 = list1.next;
                } else {
                    pointer.next = list2;
                    list2 = list2.next;
                }
                pointer = pointer.next;
            } else {
                while (list1 != null) {
                    pointer.next = list1;
                    list1 = list1.next;
                    pointer = pointer.next;
                }
                while (list2 != null) {
                    pointer.next = list2;
                    list2 = list2.next;
                    pointer = pointer.next;
                }
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode list1 = NodeUtils.buildList("1,3,5,7,9");
        ListNode list2 = NodeUtils.buildList("2,4,6,8,10,11,12,13");
        A0021 algorithm = new A0021();
        ListNode listNode = algorithm.mergeTwoLists(list1, list2);
        NodeUtils.print(listNode);
    }

}
