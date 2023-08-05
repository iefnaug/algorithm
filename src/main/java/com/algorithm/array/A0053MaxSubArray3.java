package com.algorithm.array;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * @author GF
 * @since 2023/8/4
 */
public class A0053MaxSubArray3 {


    public int maxSubArray(int[] nums) {
        int max = nums[0], sub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sub = Math.max(sub + nums[i], nums[i]);
            max = Math.max(max, sub);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {
                -2,1,-3,4,-1,2,1,-5,4
        };
        A0053MaxSubArray3 algorithm = new A0053MaxSubArray3();
        int max = algorithm.maxSubArray(nums);
        System.out.println(max);
    }

}
