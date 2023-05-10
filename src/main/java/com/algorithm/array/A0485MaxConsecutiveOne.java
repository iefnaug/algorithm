package com.algorithm.array;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 *
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 *
 * @author GF
 * @since 2023/5/10
 */
public class A0485MaxConsecutiveOne {

    public int findMaxConsecutiveOnes(int[] nums) {
        int consecutive = 0;
        int index = 0, len = nums.length;
        int count = 0;
        while (index < len) {
            if (nums[index++] == 0) {
                consecutive = Math.max(consecutive, count);
                count = 0;
            } else {
                count++;
            }
        }
        consecutive = Math.max(consecutive, count);
        return consecutive;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        A0485MaxConsecutiveOne algorithm = new A0485MaxConsecutiveOne();
        int maxConsecutiveOnes = algorithm.findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }

}
