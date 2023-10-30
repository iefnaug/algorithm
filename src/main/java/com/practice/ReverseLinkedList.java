package com.practice;

/**
 * @author GF
 * @since 2023/10/29
 */
public class ReverseLinkedList {

    public static class Node {
        int val;
        Node next;

        public Node() {}
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node reverseList(Node head) {
        if (head == null) return null;
        Node sentinel = new Node();
        while (head != null) {
            Node tmp = head;
            head = head.next;
            tmp.next = sentinel.next;
            sentinel.next = tmp;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        Node head = reverseList(n1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}
