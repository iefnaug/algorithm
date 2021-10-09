package com.algorithm.array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -10^5 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * @author GF
 * @since 2021/10/9
 */
public class A0053MaximumSubarray {

    /**
     * 动态规划 f(i)表示以位置i上的元素为结尾的子串的最大和
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxSum = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                -2,1,-3,4,-1,2,1,-5,4
        };
        System.out.println(maxSubArray(nums));
    }

}
