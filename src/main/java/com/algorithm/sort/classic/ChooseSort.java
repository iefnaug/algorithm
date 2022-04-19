package com.algorithm.sort.classic;

/**
 * 选择排序
 */
public class ChooseSort {

    /**
     * n^2
     */
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                1,3,5,7,9,2,4,6,8,10
        };
        ChooseSort chooseSort = new ChooseSort();
        chooseSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
