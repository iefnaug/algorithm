package com.a2024.sort;

import java.util.Arrays;

/**
 * @author gf01867832
 * @since 2024/6/11
 */
public class QuickSort2 {
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = pivot(nums, left, right);
        quickSort(nums, 0, pos - 1);
        quickSort(nums, pos + 1, right);
    }

    private int pivot(int[] nums, int left, int right) {
        int val = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= val) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= val) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = val;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,3,5,7,9,2,4,6,8,0
        };
        QuickSort2 algorithm = new QuickSort2();
        algorithm.quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
