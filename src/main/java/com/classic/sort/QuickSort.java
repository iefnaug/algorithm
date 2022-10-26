package com.classic.sort;

/*
 * @author GF
 * @since 2022/10/24
 */
public class QuickSort {

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pos = partition(nums, left, right);
        quickSort(nums, left, pos - 1);
        quickSort(nums, pos + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left, j = right + 1;
        int val = nums[i];
        while (true) {
            while (nums[++i] < val) if (i == right) break;

            while (nums[--j] > val) if (j == left) break;

            if (i >= j) break;

            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
//        nums[j] = nums[i] ^ nums[j];
//        nums[i] = nums[i] ^ nums[j];
//        nums[j] = nums[i] ^ nums[j];
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {
                1,3,5,7,9,2,4,6,5,7,4,10
        };
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }

        System.out.println();

    }

}

