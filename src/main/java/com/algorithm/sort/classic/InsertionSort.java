package com.algorithm.sort.classic;

/**
 * 插入排序
 */
public class InsertionSort {

    /**
     * O(n^2)
     */
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertValue = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > insertValue ; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                1,3,5,7,7,7,9,2,4,6,8
        };
        InsertionSort sort = new InsertionSort();
        sort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
