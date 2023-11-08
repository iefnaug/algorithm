package com.algorithm.math;

/**
 * @author GF
 * @since 2023/11/8
 */
public class A0326PowerOfThree {

    public boolean isPowerOfThree(int n) {
        while (true) {
            if (n % 3 != 0) {
                return n == 1;
            }
            n = n / 3;
        }
    }

    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        A0326PowerOfThree algorithm = new A0326PowerOfThree();
        System.out.println(algorithm.isPowerOfThree(2));
        System.out.println(algorithm.isPowerOfThree(18));
        System.out.println(algorithm.isPowerOfThree(27));

        long num = 1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (num * 3 > Integer.MAX_VALUE) {
                System.out.println(num);
                break;
            }
            num *= 3;
        }

    }

}
