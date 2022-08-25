package com.algorithm.binarysearch;


/**
 * 实现pow(x, n)，即计算 x 的整数n 次幂函数（即，xn ）。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * 
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= xn <= 10^4
 *
 * <a href="https://leetcode.cn/problems/powx-n">algorithm</a>
 */
public class A0050Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean positive = n >= 0;
        int times = Math.abs(n);
        double multi = 1d;
        while (times > 0) {
            multi *= x;
            times--;
        }
        if (positive) {
            return multi;
        } else {
            return 1d / multi;
        }
    }

    /**
     * 二分法
     */
    public double myPow2(double x, int n) {
        return n > 0 ? recursive(x, n) : 1d / recursive(x, -n);
    }

    private double recursive(double x, int n) {
        if (n == 0) {
            return 1d;
        }
        double k = recursive(x, n / 2);
        return n % 2 == 0 ? k * k : k * k * x;
    }


    public static void main(String[] args) {
        A0050Pow algorithm = new A0050Pow();
        double result = algorithm.myPow2(2, -2);
        System.out.println(result);
    }

}
