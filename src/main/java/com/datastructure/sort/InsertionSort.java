package com.datastructure.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 通常人们整理桥牌的方法是一张一张的来，将每一张牌插入到其他已经有序的牌中的适当位置。
 * 在计算机的实现中，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位。这种算法叫做插入排序
 *
 * @author GF
 * @since 2023/8/6
 */
public class InsertionSort {

    /**
     * 一次交换
     * O(n^2)
     */
    public static <T extends Comparable<T>> void sort(T[] g) {
        int len = g.length;
        for (int i = 1; i < len; i++) {
            T record = g[i];
            for (int j = i - 1; j >= 0; j--) {
                if (record.compareTo(g[j]) >= 0) {
                    System.arraycopy(g, j+1, g, j+2, i-j-1);
                    g[j+1] = record;
                    break;
                } else if (j == 0) {
                    System.arraycopy(g, 0, g, 1, i);
                    g[0] = record;
                }
            }
        }
    }


    /**
     * 每次交换
     * O(n^2)
     */
    public static <T extends Comparable<T>> void sort2(T[] g) {
        int len = g.length;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 && g[j+1].compareTo(g[j]) < 0; j--) {
                swap(g, j+1, j);
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] g, int a, int b) {
        T tmp = g[a];
        g[a] = g[b];
        g[b] = tmp;
    }


    public static void main(String[] args) {
        Integer[] g = {
                2,5,8,9,4,0
//                1,2,3,4,5
        };
        sort(g);
//        sort2(g);
        Arrays.stream(g).forEach(System.out::println);
    }

}
