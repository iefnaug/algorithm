package com.algorithm.math;

/**
 * @author GF
 * @since 2023/11/8
 */
public class A0204CountPrimes {

    public int countPrimes(int n) {
        int ret = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                ret++;
            }
        }
        return ret;
    }

    private boolean isPrime(int k) {
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 100;
        A0204CountPrimes algorithm = new A0204CountPrimes();
        int count = algorithm.countPrimes(n);
        System.out.println(count);
    }

}
