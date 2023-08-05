package com.interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author GF
 * @since 2023/8/3
 */
public class Eliminate {


    public static int eliminate(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches()) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != str.charAt(i)) {
                sb.append(str.charAt(i));
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        System.out.println(sb);
        return sb.length();
    }

    public static void main(String[] args) {
        String str = "abccbdeffekkm";
        System.out.println(eliminate(str));
    }

}
