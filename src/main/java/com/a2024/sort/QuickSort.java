package com.a2024.sort;

import java.util.Arrays;

/**
 * @author gf01867832
 * @since 2024/5/26
 */
public class QuickSort {

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = getPivot(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }


    public int getPivot(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,3,5,7,9,2,4,6,8,0
        };
        QuickSort algorithm = new QuickSort();
        algorithm.quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
