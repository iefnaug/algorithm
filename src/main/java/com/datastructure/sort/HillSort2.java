package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author GF
 * @since 2023/8/11
 */
public class HillSort2 {


    public static void sort(int[] nums) {
        int len = nums.length;
        int g = 1;
        while (g < len) {
            g = 3 * g;
        }
        while (g >= 1) {
            for (int i = g; i < len; i++) {
                for (int j = i; j >= g; j--) {
                    if (nums[j] < nums[j-g]) {
                        swap(nums, j, j-g);
                    }
                }
            }
            g = g/3;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,2,4,6,8,0,30,40,20};
        sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
