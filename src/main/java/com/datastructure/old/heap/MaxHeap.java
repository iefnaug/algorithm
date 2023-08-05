package com.datastructure.old.heap;

/**
 * @author GF
 * @since 2023/5/30
 */
public class MaxHeap {

    int[] array;
    int size;

    public MaxHeap(int capacity) {
        array = new int[capacity];
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void addElements(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    /**
     * 建堆
     */
    public void heapify() {
        //找到最后一个非叶子结点 size/2 - 1
        for (int i = size/2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    public int peek() {
        return array[0];
    }

    public int poll() {
        return poll(0);
    }


    public int poll(int index) {
        int removed = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return removed;
    }

    public boolean offer(int value) {
        if (isFull()) {
            return false;
        }
        up(value);
        size++;
        return true;
    }

    private void up(int value) {
        int child = size;
        while (child > 0) {
            //计算任意节点的父节点
            int parent = (child - 1)/2;
            if (value > array[parent]) {
                swap(child, parent);
                child = parent;
            } else {
                break;
            }
        }
        array[child] = value;
    }


    private void down(int parent) {
        //计算任意节点的左右孩子
        int left = parent * 2 + 1, right = parent * 2 + 2;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        MaxHeap maxHeap = new MaxHeap(20);
        maxHeap.addElements(array);
        maxHeap.heapify();
        System.out.println();
    }

}
