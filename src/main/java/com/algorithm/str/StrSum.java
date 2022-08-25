package com.algorithm.str;

public class StrSum {


    public static String add(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null ||  b.length() == 0) {
            return a;
        }
        int aIndex = a.length() - 1, bIndex = b.length() - 1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int num1 = 0, num2 = 0;
            if (aIndex >= 0) {
                num1 = a.charAt(aIndex) - '0';
            }
            if (bIndex >= 0) {
                num2 = b.charAt(bIndex) - '0';
            }
            int sum = num1 + num2 + flag;
            if (sum > 9) {
                sum -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            sb.append(sum);
            aIndex--;
            bIndex--;
        }
        if (flag > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "92345";
        String b = "12346";
        System.out.println(add(a, b));
    }


}
