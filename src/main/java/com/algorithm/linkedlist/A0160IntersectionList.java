package com.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 * @author GF
 * @since 2023/5/2
 */
public class A0160IntersectionList {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> cache = new HashMap<>();
        while (headA != null) {
            cache.put(headA, headA.val);
            headA = headA.next;
        }
        while (headB != null) {
            if (cache.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }



}
