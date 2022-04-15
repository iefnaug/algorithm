package com.algorithm.sort.classic;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * NlogN
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int temp = nums[i];
            while (i < j) {
                while (nums[j] >= temp && i < j) {
                    j--;
                }
                nums[i] = nums[j];
                while (nums[i] < temp && i < j) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = temp;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] {
                1,9,3,8,4,7,6,5,2
        };
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
