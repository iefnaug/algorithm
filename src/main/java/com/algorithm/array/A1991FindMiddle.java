package com.algorithm.array;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。
 *
 * 中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
 *
 * 如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
 *
 * 请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,-1,8,4]
 * 输出：3
 * 解释：
 * 下标 3 之前的数字和为：2 + 3 + -1 = 4
 * 下标 3 之后的数字和为：4 = 4
 * 示例 2：
 *
 * 输入：nums = [1,-1,4]
 * 输出：2
 * 解释：
 * 下标 2 之前的数字和为：1 + -1 = 0
 * 下标 2 之后的数字和为：0
 *
 *
 * 1 <= nums.length <= 100
 * -1000 <= nums[i] <= 1000
 *
 *
 * @author GF
 * @since 2023/4/18
 */
public class A1991FindMiddle {

    public int findMiddleIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0, rightSum = sum;
        for (int i = 0; i < len; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public int findMiddleIndex2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < len; i++) {
            if (leftSum * 2 == sum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {
        A1991FindMiddle algorithm = new A1991FindMiddle();

        int []nums = {2,3,-1,8,4};

        int middleIndex = algorithm.findMiddleIndex(nums);
        int middleIndex2 = algorithm.findMiddleIndex2(nums);

        System.out.println(middleIndex);
        System.out.println(middleIndex2);
    }


}
