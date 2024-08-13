package com.offer;

/**
 * @since 2024/8/13
 */
public class Offer002 {

    public String addBinary(String a, String b) {
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();
        char[] result = new char[Math.max(arr.length, brr.length)];
        int aIndex = arr.length - 1, bIndex = brr.length - 1, resultIndex = result.length - 1;
        int add = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            int sum = (aIndex >= 0 ? arr[aIndex--] - '0' : 0) + (bIndex >= 0 ? brr[bIndex--] - '0' : 0) + add;
            if (sum >= 2) {
                result[resultIndex--] = (char)(sum - 2 + '0');
                add = 1;
            } else {
                result[resultIndex--] = (char)(sum + '0');
                add = 0;
            }
        }
        if (add == 1) {
            char[] ret = new char[result.length + 1];
            System.arraycopy(result, 0, ret, 1, result.length);
            ret[0] = '1';
            return new String(ret);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Offer002 algorithm = new Offer002();
        String s = algorithm.addBinary("1001", "1110");
        System.out.println(s);
    }
}
