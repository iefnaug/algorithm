package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author GF
 * @since 2023/8/13
 */
public class QuickSort {

    public static  <T extends Comparable<T>> void sort(T[] g, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = partition(g, left, right);
        sort(g, left, pos - 1);
        sort(g, pos + 1 , right);
    }

    private static  <T extends Comparable<T>> int partition(T[] g, int left, int right) {
        int i = left, j = right + 1;
        T v = g[left];
        while (true) {
            while (g[++i].compareTo(v) < 0) {
                if (i == right) {
                    break;
                }
            }
            while (g[--j].compareTo(v) > 0) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(g, i, j);
        }
        swap(g, left, j);
        return j;
    }

    private static  <T extends Comparable<T>> void swap(T[] g, int i, int j) {
        T tmp = g[i];
        g[i] = g[j];
        g[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] g = {1,3,5,7,9,2,4,6,8,0};
        sort(g, 0, g.length - 1);
        Arrays.stream(g).forEach(System.out::println);
    }

}
