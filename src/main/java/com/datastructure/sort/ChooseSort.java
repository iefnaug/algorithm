package com.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 一种最简单的排序算法是这样的:
 * 首先，找到数组中最小的那个元素，
 * 其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
 * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。
 * 这种方法 叫做选择排序，因为它在不断地选择剩余元素之中的最小者。
 *
 * @author GF
 * @since 2023/8/5
 */
public class ChooseSort {

    /**
     * O(n^2)
     */
    public static <T extends Comparable<T>> void sort(T[] g, boolean asc) {
        int len = g.length;
        for (int i = 0; i < len - 1; i++) {
            if (asc) {
                int min = i;
                //找到i后面小于位置i元素的最小元素
                for (int j = i + 1; j < len; j++) {
                    if (g[min].compareTo(g[j]) > 0) {
                        min = j;
                    }
                }
                swap(g, i, min);
            } else {
                int max = i;
                //找到i后面大于位置i的最大元素
                for (int j = i + 1; j < len; j++) {
                    if (g[max].compareTo(g[j]) < 0) {
                        max = j;
                    }
                }
                swap(g, i, max);
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] g, int m, int n) {
        T tmp = g[m];
        g[m] = g[n];
        g[n] = tmp;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,3,5,7,9,2,4,6,8,0};
//        sort(nums, true);
        sort(nums, false);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
