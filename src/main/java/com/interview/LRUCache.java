package com.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GF
 * @since 2023/8/10
 */
public class LRUCache {


    private static class Node {
        Integer key;
        Integer value;
        Node pre;
        Node next;
    }

    private int capacity;

    private int size;

    private Node head;

    private Node tail;

    private Map<Integer, Node> container = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }


    public void put(Integer key, Integer value) {
        boolean keyExists = container.get(key) != null;
        if (keyExists) {
            Node currentNode = container.get(key);
            currentNode.pre.next = currentNode.next;
            currentNode.next.pre = currentNode.pre;
            //移动到队首
            currentNode.value = value;
            moveToHead(currentNode);
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            moveToHead(newNode);
            container.put(key, newNode);
            if (size == capacity) {
                deleteTail();
            } else {
                size++;
            }
        }
    }

    public int get(Integer key) {
        Node currentNode = container.get(key);
        if (currentNode == null) {
            return -1;
        }
        currentNode.pre.next = currentNode.next;
        currentNode.next.pre = currentNode.pre;
        moveToHead(currentNode);
        return currentNode.value;
    }

    private void moveToHead(Node node) {
        Node headNextNode = head.next;
        head.next = node;
        node.next = headNextNode;
        node.pre = head;
        headNextNode.pre = node;
    }

    private void deleteTail() {
        Node preNode = tail.pre;
        tail.pre = preNode.pre;
        preNode.pre.next = tail;
        preNode.pre = null;
        preNode.next = null;
        container.remove(preNode.key);
    }

    private void printKeyOrder() {
        Node start = head.next;
        while (start != tail) {
            System.out.print(start.key + " ");
            start = start.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(10);
//        for (int i = 0; i < 10; i++) {
//            lruCache.set(i, i);
//        }
//        lruCache.printKeyOrder();
//        lruCache.set(10, 10);
//        lruCache.printKeyOrder();
//        lruCache.set(5, 0);
//        lruCache.printKeyOrder();
//        lruCache.get(3);
//        lruCache.printKeyOrder();
//        lruCache.set(100, 100);
//        lruCache.printKeyOrder();

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }


}
