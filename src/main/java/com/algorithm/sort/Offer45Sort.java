package com.algorithm.sort;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 */
public class Offer45Sort {

    public String minNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String leftJoinRight = nums[i] + "" + nums[j];
                String rightJoinLeft = nums[j] + "" + nums[i];
                if (leftJoinRight.compareTo(rightJoinLeft) > 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int num : nums) {
            result.append(num);
        }
        return result.toString();
    }

}
