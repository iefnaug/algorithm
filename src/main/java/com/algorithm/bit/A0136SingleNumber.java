package com.algorithm.bit;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * <a href="https://leetcode.cn/problems/single-number">algorithm</a>
 */
public class A0136SingleNumber {

    /**
     * a ^ 0 = a
     * a ^ a = 0
     * 异或运算满足交换律和结合律
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        A0136SingleNumber algorithm = new A0136SingleNumber();
        int result = algorithm.singleNumber(new int[]{
                2, 5, 7, 8, 5, 2, 7
        });
        System.out.println(result);
    }

}
