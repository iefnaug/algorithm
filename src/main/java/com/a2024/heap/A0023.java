package com.a2024.heap;

import com.entity.ListNode;
import com.utils.NodeUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * @author gf01867832
 * @since 2024/4/28
 */
public class A0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        priorityQueue.addAll(Arrays.stream(lists).collect(Collectors.toList()));
        ListNode head = new ListNode();
        ListNode pointer = head;
        while (priorityQueue.peek() != null) {
            ListNode poll = priorityQueue.poll();
            ListNode pollNext = poll.next;
            pointer.next = poll;
            pointer = poll;
            pointer.next = null;
            if (pollNext != null) {
                priorityQueue.add(pollNext);
            }
        }
        return head.next;
    }
    public static void main(String[] args) {
//    [[1,4,5],[1,3,4],[2,6]]
        ListNode n1 = NodeUtils.buildList("1,4,5");
        ListNode n2 = NodeUtils.buildList("1,3,4");
        ListNode n3 = NodeUtils.buildList("2,6");
        ListNode[] lists = {n1, n2, n3};
        A0023 a0023 = new A0023();
        ListNode listNode = a0023.mergeKLists(lists);
        while(listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }


}
