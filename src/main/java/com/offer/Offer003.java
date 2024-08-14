package com.offer;

/**
 * 二进制数中1的个数
 * @since 2024/8/14
 */
public class Offer003 {


    public int bitCount(int i) {
        int count = 0;
        while (i != 0) {
            if ((i & 1) == 1) {
                count++;
            }
            i >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Offer003 algorithm = new Offer003();
        int count = algorithm.bitCount(-10);
        System.out.println(count);
    }

}
