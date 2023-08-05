package com.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GF
 * @since 2023/8/4
 */
public class VegetarianPartner {


    public static void main(String[] args) {


        // 输入的数字先分好为奇数、偶数两组
        List<Integer> evenList= new ArrayList<>();
        List<Integer> oddList= new ArrayList<>();

        int size = evenList.size();
        int count = 0;

        // 已经匹配的数的伴侣
        int[] evensMatch = new int[size];

        for (Integer odd : oddList) {
            // 用于标记对应的数是否查找过
            int[] used = new int[size];

            if (find(odd, evenList, used, evensMatch)) {
                count ++;
            }
        }

    }

    // 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
    // 0和1既不是质数也不是合数，最小的质数是2
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // 偶数可以被2 整除的整数
    private static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }

        return false;
    }

    private static boolean find(int odd, List<Integer> evens, int[] used, int[] evensMatch) {
        // 遍历偶数：去检查当前传入的奇数能否与偶数哪些数匹配
        for (int i = 0; i < evens.size(); i++) {
            // 如果当前偶数与传入的奇数匹配，并且当前偶数位还没有匹配过奇数
            if (isPrime(odd + evens.get(i)) && used[i] == 0) {
                // 设置当前偶数位匹配为true，也就是 1
                used[i] = 1;

                // 如果第i个偶数没有伴侣
                // 或者第i个偶数原来有伴侣，并且该伴侣能够重新找到伴侣的话(这里有递归调用)
                // 则奇数odd可以设置为第i个偶数的伴侣
                // 这里采用了匈牙利算法，能让则让
                if (evensMatch[i] == 0 || find(evensMatch[i], evens, used, evensMatch)) {
                    evensMatch[i] = odd;
                    return true;
                }
            }
        }

        // 遍历完偶数都没有可以与传入奇数做伴侣的，该奇数只没有配对了
        return false;
    }
}
