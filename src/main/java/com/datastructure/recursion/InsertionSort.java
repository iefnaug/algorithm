package com.datastructure.recursion;

import java.util.Arrays;

/**
 * @author GF
 * @since 2023/4/24
 */
public class InsertionSort {


    public static void sort(int[] a) {
        insertion(a, 1);
    }


    /**
     * @param index 右侧未排序数据的边界
     */
    private static void insertion(int[] a, int index) {
        if (index == a.length) {
            return;
        }

        int inserting = a[index];
        int i = index - 1;
        while (i >= 0 && a[i] > inserting) {
            a[i+1] = a[i];
            i--;
        }
        a[i+1] = inserting;

        insertion(a, index + 1);
    }

    public static void main(String[] args) {
        int[] a = {2,4,5,6,1,3,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
