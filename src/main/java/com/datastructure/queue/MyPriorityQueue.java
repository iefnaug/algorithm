package com.datastructure.queue;


/**
 * 堆的实现：完全二叉树
 * 大顶堆：父节点大于子节点
 * 小顶堆：父节点小于子节点
 *
 * 队列从索引0开始存储数据：
 * - 节点i的父节点位置：floor((i-1)/2), i>0
 * - 节点i的子节点位置：左孩子(i*2+1) , 右孩子(i*2+2),  计算结果小于节点个数
 *
 *
 * @author GF
 * @since 2023/5/28
 */
public class MyPriorityQueue <T extends Priority> implements Queue<T> {

    private Priority[] array;
    private int size;

    public MyPriorityQueue(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(T t) {
        if (isFull()) {
            return false;
        }
        int childIndex = size++;
        int parentIndex = (childIndex - 1)/2;
        while (childIndex > 0 && t.priority() > array[parentIndex].priority()) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;
        }
        array[childIndex] = t;
        return true;
    }

    @Override
    public T poll() {
        if (size == 0) {
            throw new RuntimeException("no element");
        }

        Priority removed = array[0];
        array[0] = array[size-1];
        array[size-1] = null;

        size--;
        down(0);
        return (T) removed;
    }

    private void down(int parent) {
        int left = parent * 2 + 1, right = parent * 2 + 2;
        int max = parent;
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) array[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }


    public static void main(String[] args) {
        MyPriorityQueue<Person> priorityQueue = new MyPriorityQueue<>(20);
        for (int i = 0; i < 20; i+=2) {
            Person p = new Person("p" + i, i);
            priorityQueue.offer(p);
        }
        for (int i = 1; i < 20; i+=2) {
            Person p = new Person("p" + i, i);
            priorityQueue.offer(p);
        }
        for (int i = 0; i < 20; i++) {
            Person person = priorityQueue.poll();
            System.out.println(person.getName() + "," + person.getAge());
        }
    }


}
