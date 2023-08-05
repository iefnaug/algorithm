package com.datastructure.old.queue;

/**
 * @author GF
 * @since 2023/5/28
 */
public interface Queue<T> {

    boolean offer(T t);

    T poll();

    T peek();

    int size();

    boolean isFull();

}
