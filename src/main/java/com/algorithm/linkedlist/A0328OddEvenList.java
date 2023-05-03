package com.algorithm.linkedlist;

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * 提示:
 *
 * n ==  链表中的节点数
 * 0 <= n <= 10^4
 * -10^6 <= Node.val <= 10^6
 *
 * @author GF
 * @since 2023/5/4
 */
public class A0328OddEvenList {


    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd  = new ListNode();
        ListNode oddStart = odd;
        ListNode even = new ListNode();
        ListNode evenStart = even;

        while (head != null) {
            odd.next = head;
            even.next = head.next;
            odd = odd.next;
            even = even.next;
            if (even == null) {
                break;
            }
            head = even.next;
        }
        odd.next = evenStart.next;
        return oddStart.next;
    }

}
