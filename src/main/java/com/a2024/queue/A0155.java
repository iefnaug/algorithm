package com.a2024.queue;

/**
 * @since 2024/6/28
 */
public class A0155 {

    public static class MinStack {

        private int[] table;
        private int size;
        private int min = Integer.MAX_VALUE;

        public MinStack() {
            table = new int[10];
            size = 0;
        }

        public void push(int val) {
            ensureCapacity();
            table[size++] = val;
            min = Integer.min(min, val);
        }

        private void ensureCapacity() {
            if (size >= table.length) {
                int[] newTable = new int[table.length * 3 / 2];
                System.arraycopy(table, 0, newTable, 0, table.length);
                table = newTable;
            }
        }

        public void pop() {
            if (size > 0) {
                int removed = table[--size];
                if (removed == min) {
                    min = Integer.MAX_VALUE;
                    for (int i = 0; i < size; i++) {
                        min = Integer.min(table[i], min);
                    }
                }
            }
        }

        public int top() {
            return table[size-1];
        }

        public int getMin() {
            return min;
        }

    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
