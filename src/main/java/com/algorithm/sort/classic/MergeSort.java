package com.algorithm.sort.classic;

/**
 * @author GF
 * @since 2022/9/19
 */
public class MergeSort {


    /**
     * 分治思想
     */
    public void mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1, tmp);
    }

    public void sort(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (right - left) / 2 + left;
            sort(nums, left, mid, tmp);
            sort(nums, mid + 1, right, tmp);
            merge(nums, left, mid, right, tmp);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        int m = left, n = 0;
        while (m <= right) {
            nums[m++] = tmp[n++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {
                1,3,5,7,9,2,4,6,8,10
        };
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums, 0, nums.length - 1, new int[nums.length]);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
