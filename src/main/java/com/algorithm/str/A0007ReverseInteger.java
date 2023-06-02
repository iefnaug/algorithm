package com.algorithm.str;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * -2^31 <= x <= 2^31 - 1
 * @author GF
 * @since 2023/6/3
 */
public class A0007ReverseInteger {

    public int reverse(int x) {
        int reverseX = 0;
        while (x != 0) {
            if (Integer.MIN_VALUE / 10 > reverseX || Integer.MAX_VALUE / 10 < reverseX) {
                return 0;
            }
            int num = x % 10;
            reverseX = reverseX * 10 + num;
            x = x / 10;
        }
        return reverseX;
    }

    public static void main(String[] args) {
         A0007ReverseInteger algorithm = new A0007ReverseInteger();
        System.out.println(algorithm.reverse(-1234));
    }

}
