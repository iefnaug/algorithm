package com.algorithm.array;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * <a href="https://leetcode.cn/problems/3sum-closest">algorithm</a>
 * @author GF
 * @since 2022/9/23
 */
public class A0016ThreeSumCloset {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int threeSum = 0, diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (target - sum < diff) {
                        diff = target - sum;
                        threeSum = sum;
                    }
                    left++;
                } else {
                    if (sum - target < diff) {
                        diff = sum - target;
                        threeSum = sum;
                    }
                    right--;
                }
            }
        }
        return threeSum;
    }

    public static void main(String[] args) {
        int[] nums = {
//                -1,2,1,-4
//                1,1,1,1
                1,1,1,0
        };
        A0016ThreeSumCloset algorithm = new A0016ThreeSumCloset();
        final int result = algorithm.threeSumClosest(nums, -100);
        System.out.println(result);

    }

}
