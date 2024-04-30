package com.a2024.list;

import com.entity.ListNode;
import com.utils.NodeUtils;

/**
 2. 两数相加

 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

 请你将两个数相加，并以相同形式返回一个表示和的链表。

 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[7,0,8]
 解释：342 + 465 = 807


 * @author gf01867832
 * @since 2024/4/30
 */
public class A0002 {

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode sentinel = new ListNode();
//        ListNode pointer = sentinel;
//        int add = 0;
//        while (l1 != null && l2 != null) {
//            int sum = l1.val + l2.val + add;
//            if (sum > 9) {
//                add = 1;
//                sum -= 10;
//            } else {
//                add = 0;
//            }
//            ListNode newNode = new ListNode(sum);
//            pointer.next = newNode;
//            pointer = newNode;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        ListNode l3 = l1 != null ? l1 : l2;
//        while (l3 != null) {
//            int sum = l3.val + add;
//            if (sum > 9) {
//                add = 1;
//                sum -= 10;
//            } else {
//                add = 0;
//            }
//            l3.val = sum;
//            pointer.next = l3;
//            pointer = l3;
//            l3 = l3.next;
//        }
//        if (add == 1) {
//            pointer.next = new ListNode(add);
//        }
//        return sentinel.next;
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode pointer = sentinel;
        int add = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + add;
            if (sum > 9) {
                add = 1;
                sum -= 10;
            } else {
                add = 0;
            }
            pointer.next = new ListNode(sum);
            pointer = pointer.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null ) l2 = l2.next;
        }
        if (add == 1) {
            pointer.next = new ListNode(add);
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
//        ListNode l1 = NodeUtils.buildList("2,4,3");
//        ListNode l2 = NodeUtils.buildList("5,6,4");

        ListNode l1 = NodeUtils.buildList("9,9,9,9,9,9,9");
        ListNode l2 = NodeUtils.buildList("9,9,9,9");

        A0002 algorithm = new A0002();
        ListNode listNode = algorithm.addTwoNumbers(l1, l2);
        NodeUtils.print(listNode);
    }

}
