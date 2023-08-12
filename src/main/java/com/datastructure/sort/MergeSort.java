package com.datastructure.sort;

import java.util.Arrays;

/**
 * 不断将两个小的有序数组，合并成一个大的有序数组
 * @author GF
 * @since 2023/8/12
 */
public class MergeSort {


    /**
     * O(NlogN)
     */
    public static <T extends Comparable<T>> void sort(T[] g, T[] f, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >>> 1;
        sort(g, f,left, mid);
        sort(g, f,mid + 1, right);
        merge(left, mid, right, g, f);
    }

    private static <T extends Comparable<T>> void merge(int left, int mid, int right, T[] g, T[] f) {
        //拷贝到辅助数组
        System.arraycopy(g, left, f, left, right - left + 1);
        int i = left, j = mid + 1;
        int index = left;
        while (index <= right) {
            if (i > mid) {
                g[index++] = f[j++];
            } else if (j > right) {
                g[index++] = f[i++];
            } else if (f[i].compareTo(f[j]) < 0) {
                g[index++] = f[i++];
            } else {
                g[index++] = f[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1,3,5,7,9,2,4,6,8,0};
        sort(nums, new Integer[nums.length], 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }


}
