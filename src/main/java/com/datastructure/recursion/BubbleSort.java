package com.datastructure.recursion;

import java.util.Arrays;

/**
 * 冒泡
 * @author GF
 * @since 2023/4/24
 */
public class BubbleSort {


    /**
     * @param j 未排序数据的右边界
     */
    private static void bubble(int[] a, int j) {
        if (j <= 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                x = i;
            }
        }
        bubble(a, x);
    }

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {

        int[] a = {1,3,5,7,9,2,4,6};
        sort(a);

    }

}
