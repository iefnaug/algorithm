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
            for (int j = i - 1; j >= 0 ; j--) {
                if (nums[i] >= nums[j]) {
                    if (j < i - 1) {
                        move(nums, j + 1, i - 1, nums[i]);
                    }
                    break;
                }
            }
        }
    }

    private void move(int[] nums, int start, int end, int target) {
        System.arraycopy(nums, start, nums, start + 1, end + 1 - start);
        nums[start] = target;
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
