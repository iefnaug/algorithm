package com.algorithm.array;

import java.util.Arrays;

/**
 * @author GF
 * @since 2023/11/6
 */
public class A0147MinStack {

    private int[] stack;

    private int capacity;
    private int size;


    private Integer min;

    public A0147MinStack() {
        capacity = 16;
        stack = new int[capacity];
        size = 0;
    }

    public void push(int val) {
        if (size == capacity) {
            resize();
        }
        stack[size++] = val;
        if (min == null) {
            min = val;
        } else {
            min = Math.min(min, val);
        }
    }

    private void resize() {
        if (capacity == Integer.MAX_VALUE) {
            throw new RuntimeException("max size arrived");
        }
        long newCapacity = capacity * 3L / 2;
        if (newCapacity > Integer.MAX_VALUE) {
            newCapacity = Integer.MAX_VALUE;
        }
        int[] newStack = new int[(int)newCapacity];
        System.arraycopy(stack, 0, newStack, 0, capacity);
        stack = newStack;
        capacity = newStack.length;
    }

    public void pop() {
        if (size == 0) {
            throw new RuntimeException("stack is empty");
        }
        if (--size == 0) {
            min = null;
            return;
        }
        if (stack[size] != min) {
            return;
        }
        int[] sortStack = new int[size];
        System.arraycopy(stack, 0, sortStack, 0, size);
        Arrays.sort(sortStack);
        min = sortStack[0];    }

    public int top() {
        if (size == 0) {
            throw new RuntimeException("stack is empty");
        }
        return stack[size-1];
    }

    public int getMin() {
        if (size == 0) {
            throw new RuntimeException("stack is empty");
        }
        return min;
    }


}
