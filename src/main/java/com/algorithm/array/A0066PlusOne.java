package com.algorithm.array;

import java.util.Arrays;

/**
 * @author GF
 * @since 2023/6/15
 */
public class A0066PlusOne {

    public int[] plusOne(int[] digits) {
        int add = 1, len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + add;
            if (sum > 9) {
                add = 1;
                sum = sum - 10;
            } else {
                add = 0;
            }
            digits[i] = sum;
            if (add == 0)
                break;
        }
        if (add == 1) {
            int[] result = new int[len + 1];
            System.arraycopy(digits, 0, result, 1, len);
            result[0] = add;
            return result;
        }
        return digits;
    }


    public static void main(String[] args) {
        int[] digits = {
//                9,9,9,9
                1,2,3,5
        };
        A0066PlusOne algorithm = new A0066PlusOne();
        int[] result = algorithm.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

}
