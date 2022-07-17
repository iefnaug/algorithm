package com.algorithm.str;

/*
 * @author GF
 * @since 2022/7/17
 */
public class A0091DecodeWays {

    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static int numDecodings2(String s) {
        int a = 0, b = 1, c = 0;
        for (int i = 0; i < s.length(); i++) {
            c = 0;
            if (s.charAt(i) != '0') {
                c += b;
            }
            if (i > 0 && s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }





    public static void main(String[] args) {
        String str = "226";
        System.out.println(numDecodings(str));
        System.out.println(numDecodings2(str));
    }


}
