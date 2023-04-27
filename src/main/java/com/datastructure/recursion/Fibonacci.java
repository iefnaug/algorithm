package com.datastructure.recursion;

import java.util.Arrays;

/**
 * @author GF
 * @since 2023/4/27
 */
public class Fibonacci {

    public static int f(int  n, int[] record) {
        if (record[n] >= 0) {
            return record[n];
        }
        int x = f(n - 1, record);
        int y = f(n - 2, record);
        record[n] = x + y;
        return x + y;
    }


    public static void main(String[] args) {
        int n = 8;
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        int result = f(n, cache);
        System.out.println(result);
    }

}
