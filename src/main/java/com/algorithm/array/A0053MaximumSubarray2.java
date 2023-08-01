package com.algorithm.array;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * @author GF
 * @since 2023/8/1
 */
public class A0053MaximumSubarray2 {


    public int maxSubArray(int[] nums) {
        int maxSubArr = nums[0], curSubArr = 0;
        for (int num : nums) {
            curSubArr = Math.max(num, curSubArr + num);
            maxSubArr = Math.max(maxSubArr, curSubArr);
        }
        return maxSubArr;
    }


    public static void main(String[] args) {
        int[] nums = {
                -1, -2, -3, -4
        };
        A0053MaximumSubarray2 algorithm = new A0053MaximumSubarray2();
        int result = algorithm.maxSubArray(nums);
        System.out.println(result);
    }

}
