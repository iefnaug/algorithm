package com.practice;

/**
 * @author GF
 * @since 2023/10/30
 */
public class MapHeap {

    private final int capacity;
    private final int[] table;
    private int size;

    public MapHeap(int capacity, int[] initTable) {
        if (initTable == null || initTable.length > capacity) {
            throw new RuntimeException("max heap size is " + capacity);
        }
        this.capacity = capacity;
        this.table = new int[capacity];
        System.arraycopy(initTable, 0, this.table, 0, initTable.length);
        this.size = initTable.length;
        buildHeap(initTable);
    }

    /**
     * 初始化建堆
     */
    private void buildHeap(int[] initTable) {
        int len = initTable.length;
        for(int i = len/2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 节点下沉
     * 根节点坐标: i
     * 左孩子：2*i + 1
     * 右孩子：2*i + 2
     */
    private void down(int parentIndex) {
        int newIndex = parentIndex;
        int leftChild = parentIndex * 2 + 1;
        int rightChild = parentIndex * 2 + 2;
        if (leftChild < this.size && table[leftChild] > table[newIndex]) {
            newIndex = leftChild;
        }
        if (rightChild < this.size && table[rightChild] > table[newIndex]) {
            newIndex = rightChild;
        }
        if (newIndex != parentIndex) {
            //swap
            int tmp = table[parentIndex];
            table[parentIndex] = table[newIndex];
            table[newIndex] = tmp;
            down(newIndex);
        }
    }

    /**
     * 节点上浮
     * 任意节点i
     * 父节点 (i - 1) / 2
     */
    private void up(int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        if (parentIndex >= 0 && table[parentIndex] < table[childIndex]) {
            int tmp = table[parentIndex];
            table[parentIndex] = table[childIndex];
            table[childIndex] = tmp;
            up(parentIndex);
        }
    }

    /**
     * 添加元素
     */
    public void add(int element) {
       if (size == capacity) {
           return;
       }
       table[++size] = element;
       up(size);
    }

    /**
     * 移除堆顶元素
     */
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int result = table[0];
        table[0] = table[size - 1];
        size--;
        down(0);
        return result;
    }


    public static void main(String[] args) {
        int[] table = {1,2,3,4,5,6,7};
        MapHeap mapHeap = new MapHeap(100, table);
        mapHeap.add(-1);
        mapHeap.add(8);
        Integer result = mapHeap.poll();
        System.out.println(result);
    }

}
