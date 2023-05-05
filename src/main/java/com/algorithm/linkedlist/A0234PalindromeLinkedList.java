package com.algorithm.linkedlist;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @author GF
 * @since 2023/5/4
 */
public class A0234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        slow.next = head;
        fast.next = head;
        for (;;) {
            slow = slow.next;
            if (fast.next.next != null) {
                fast = fast.next.next;
                if (fast.next == null) {
                    //偶数个结点
                    break;
                }
            } else {
                //奇数个结点
                break;
            }
        }
        if (fast.next == head) {
            //单节点
            return true;
        }
        ListNode recordPointer = slow;
        //将slow之后的结点翻转
        slow.next = reverse(slow.next);

        //比较前后两部分
        ListNode pointer1 = head;
        ListNode pointer2 = slow.next;
        while (pointer2 != null) {
            if (pointer1.val != pointer2.val) {
                return false;
            }
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        //还原翻转部分
        recordPointer.next = reverse(recordPointer.next);

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode sentinel = new ListNode();
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = sentinel.next;
            sentinel.next = node;
        }
        return sentinel.next;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            //偶数节点
            fast = reverse(slow);
        } else {
            //奇数节点
            fast = reverse(slow.next);
        }
        ListNode recordNode = fast;
        slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        //还原链表
        reverse(recordNode);
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        A0234PalindromeLinkedList algorithm = new A0234PalindromeLinkedList();
//        boolean palindrome = algorithm.isPalindrome(n1);
        boolean palindrome = algorithm.isPalindrome2(n1);
        System.out.println(palindrome);
    }

}
