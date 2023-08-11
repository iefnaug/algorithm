package com.datastructure.heap;

/**
 * 构建一个大根堆
 * @author GF
 * @since 2023/8/11
 */
public class MaxHeap {

    private final int[] elements;

    private int size;

    public MaxHeap(int capacity) {
        elements = new int[capacity];
        size = 0;
    }


    public MaxHeap(int[] elements) {
        this.elements = elements;
        size = elements.length;
        buildHeap();
    }

    private void buildHeap() {
        //最后一个带叶节点的非叶结点
        for(int i = size/2-1; i >=0; i--) {
            down(i);
        }
    }

    public void put(int value) {
        if (size >= elements.length) {
            throw new RuntimeException("no more space");
        }
        elements[size] = value;
        size++;
        up(size-1);
    }

    private void up(int childIndex) {
        int parentIndex = (childIndex - 1)/2;
        //存在父节点，并且父节点的值小于当前值，需要交换
        if (parentIndex >= 0 && elements[parentIndex] < elements[childIndex]) {
            swap(childIndex, parentIndex);
            up(parentIndex);
        }
    }

    private void swap(int a, int b) {
        int tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("no elements");
        }
        return elements[0];
    }

    public int poll() {
        int ret = elements[0];
        elements[0] = elements[size-1];
        size--;
        down(0);
        return ret;
    }

    private void down(int parentIndex) {
        int leftChildIndex = parentIndex * 2 + 1, rightChildIndex = parentIndex * 2 + 2;
        int maxIndex = parentIndex;
        if (leftChildIndex < size && elements[maxIndex] < elements[leftChildIndex]) {
            maxIndex = leftChildIndex;
        }
        if (rightChildIndex < size && elements[maxIndex] < elements[rightChildIndex]) {
            maxIndex = rightChildIndex;
        }
        if (parentIndex != maxIndex) {
            //说明有子节点大于父节点
            swap(parentIndex, maxIndex);
            down(maxIndex);
        }
    }


    public void print() {
        while (size > 0) {
            System.out.print(poll() + ", ");
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        for (int i = 0; i < 10; i++) {
            maxHeap.put(i);
        }
        maxHeap.print();

        System.out.println();

        int[] elements = {1,3,5,7,9,2,4,6,8,0};
        MaxHeap maxHeap2 = new MaxHeap(elements);
        maxHeap2.print();
    }


}
