package com.algorithm.array;

/*
 * @author GF
 * @since 2021/7/31
 */
public class ArrayList<E> {

    /**
     * 元素
     */
    private E[] elements;

    private int size = 0;

    private final static int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    /**
     * 清空数组
     */
    public void clear() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    private void ensureCapacity() {
        if (size < elements.length) {
            return;
        }
        int newCapacity = size * 3 / 2;
        E[] newElements = (E[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        final E old = elements[index];
        elements[index] = element;
        return old;
    }

    public void add(int index, E element) {
        if (index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;   
    }

    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of range");
        }
        E old = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return old;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        for (int i=0; i<size; i++) {
            sb.append(elements[i].toString());
            if (i < size-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

   
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.toString());
        System.out.println(list.remove(2));
        System.out.println();
    }

}
