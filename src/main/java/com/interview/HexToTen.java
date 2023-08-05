package com.interview;

/**
 * @author GF
 * @since 2023/8/2
 */
public class HexToTen {


    public static int hexToTen(String hex) {
        hex = hex.toUpperCase();
        int x = 1, sum = 0;
        for (int i = hex.length() - 1; i >= 2; i--) {
            if (i < hex.length() - 1) {
                x = x * 16;
            }
            char c = hex.charAt(i);
            if (c >= '0' && c <= '9') {
                sum += (c - '0') * x;
            } else if (c >= 'A' && c <= 'F') {
                sum += (c - 'A' + 10) * x;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hexToTen("0xAA"));
    }

}
