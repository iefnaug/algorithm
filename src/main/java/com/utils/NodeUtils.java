package com.utils;

import com.entity.ListNode;

/**
 * @author gf01867832
 * @since 2024/4/28
 */
public class NodeUtils {

    public static ListNode buildList(String nodes) {
        String[] node = nodes.split(",");
        ListNode sentinel = new ListNode();
        ListNode pointer = sentinel;
        for (String n : node) {
            ListNode listNode = new ListNode(Integer.parseInt(n));
            pointer.next = listNode;
            pointer = listNode;
        }
        return sentinel.next;
    }

}
