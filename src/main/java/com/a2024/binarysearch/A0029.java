package com.a2024.binarysearch;

/**
 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。

 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。

 返回被除数 dividend 除以除数 divisor 得到的 商 。

 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2^31,  2^31 − 1] 。本题中，如果商 严格大于 2^31 − 1 ，则返回 2^31 − 1 ；如果商 严格小于 -2^31 ，则返回 -2^31 。



 示例 1:

 输入: dividend = 10, divisor = 3
 输出: 3
 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 示例 2:

 输入: dividend = 7, divisor = -3
 输出: -2
 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 */
public class A0029 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int result = calculate(dividend, divisor);
        return negative == 1 ? -result : result;

    }

    /**
     * 这里实现的是两个负数的除法
     */
    private int calculate(int dividend, int divisor) {
        int result = 0;
        while (dividend < divisor) {
            int value = divisor;
            int count = 1;
            while(value >= 0xc0000000 && dividend <= value + value) {
                count += count;
                value += value;
            }
            result += count;
            dividend -= value;
        }
        return result;
    }


    public static void main(String[] args) {
//        int v = Integer.MIN_VALUE / 2;
//        System.out.println(v);
//        System.out.println(Integer.toHexString(v));
//        System.out.println(Integer.toHexString(Integer.MIN_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        System.out.println(Integer.toBinaryString(v));
//        System.out.println(Integer.toBinaryString(-2));
        A0029 a0029 = new A0029();
        int divide = a0029.divide(-100, 14);
        System.out.println(divide);
    }
}
