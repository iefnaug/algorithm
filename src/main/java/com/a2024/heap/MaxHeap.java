package com.a2024.heap;

import java.util.Objects;

/**
 * 大顶堆 - 最小N个元素
 * @author gf01867832
 * @since 2024/4/26
 */
public class MaxHeap {

    private int size;
    private int capacity;
    private int[] table;

    public MaxHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.table = new int[capacity];
    }

    public void buildHeap(int[] elements) {
        Objects.requireNonNull(elements);
        for (int i = elements.length / 2 - 1; i >= 0; i--) {
            down(elements, i);
        }
        System.arraycopy(elements, 0, table, 0, elements.length);
        size = elements.length;
    }

    private void down(int[] elements, int parent) {
        int left = 2 * parent + 1, right = 2 * parent + 2;
        int tmp = parent;
        if (left < elements.length && elements[left] > elements[tmp]) {
            tmp = left;
        }
        if (right < elements.length && elements[right] > elements[tmp]) {
            tmp = right;
        }
        if (tmp != parent) {
            swap(elements, tmp, parent);
            down(elements, tmp);
        }
    }

    private void up(int[] elements, int pos) {
        int parent = (pos - 1) / 2;
        if (elements[parent] < elements[pos]) {
            swap(elements, parent, pos);
            up(elements, parent);
        }
    }

    private void swap(int[] elements, int a, int b) {
        int tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    private void add(int element) {
        if (size == 0) {
            table[0] = element;
        }
        if (size == capacity && element < table[0]) {
            table[0] = element;
            down(table, 0);
        } else {
            table[size] = element;
            up(table, size);
            size++;
        }
    }

    public void print() {
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] elements = new int[] {
                1,2,3,4,5,6,7,8,9,10
        };
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.buildHeap(elements);
        maxHeap.add(-1);
        maxHeap.add(20);
        maxHeap.print();
    }

}
