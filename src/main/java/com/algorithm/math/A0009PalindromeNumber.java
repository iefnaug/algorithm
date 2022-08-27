package com.algorithm.math;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 * 
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 
 *
 * 提示：
 *
 * -2^31<= x <= 2^31- 1
 *
 * <a href="https://leetcode.cn/problems/palindrome-number">algorithm</a>
 */
public class A0009PalindromeNumber {

    /**
     * 反转一半
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        while (x > num) {
            int tmp = x % 10;
            x = x / 10;
            num = num * 10 + tmp;
        }
        return x == num || x == num / 10;
    }

    public static void main(String[] args) {
        A0009PalindromeNumber algorithm = new A0009PalindromeNumber();
        boolean palindrome = algorithm.isPalindrome(12321);
        System.out.println(palindrome);
    }

}
