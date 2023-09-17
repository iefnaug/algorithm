package com.interview;

import java.util.HashSet;
import java.util.Set;

public class AllSubStr {

    /**
     * 都是小写字符
     * s的全排列，属于str的子序列
     */
    public static Set<String> allSubStr(String str, String s) {

        Set<String> ret = new HashSet<>();
        if (str == null || s == null || str.length() < s.length()) {
            return ret;
        }

        int[] record = new int[26];
        char[] c = s.toCharArray();
        for (char c1 : c) {
            int i = c1 - 'a';
            record[i]++;
        }

        for (int i = 0; i < str.length() - s.length() + 1; i++) {
            int[] rec = new int[record.length];
            System.arraycopy(record, 0, rec, 0, record.length);
            boolean add = true;
            for (int j = i; j < i + s.length(); j++) {
                int index = str.charAt(j) - 'a';
                if (rec[index] == 0) {
                    add = false;
                    break;
                }
                rec[index]--;
            }
            if (add) {
                ret.add(str.substring(i, i + s.length()));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        String str = "abccba";
        String s = "abcc";
        Set<String> set = allSubStr(str, s);
        for (String ss : set) {
            System.out.println(ss);
        }
    }

}
