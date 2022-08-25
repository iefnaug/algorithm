package com.algorithm.binarysearch;

/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数dividend除以除数divisor得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 
 *
 * 示例1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * 
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * <a href="https://leetcode.cn/problems/divide-two-integers">algorithm</a>
 */
public class A0029DivideTwoIntegers {

    /**
     * 暴力，使用减法
     */
    public int divide(int dividend, int divisor) {
        //确定符号位
        int sign = ((dividend ^ divisor) >> 31 & 1) == 1 ? -1 : 1;
        long dividendLong = Math.abs(dividend);
        long divisorLong = Math.abs(divisor);
        long result = 0;
        while (dividendLong >= divisorLong) {
            dividendLong -= divisorLong;
            result++;
        }
        result *= sign;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ) {
            result = Integer.MAX_VALUE;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        A0029DivideTwoIntegers algorithm = new A0029DivideTwoIntegers();
        System.out.println(algorithm.divide(-111, 2));
    }

}
