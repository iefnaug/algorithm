package com.algorithm.str;

/**
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * 说明：
 *
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 *https://www.cnblogs.com/yjiyjige/p/3263858.html
 *
 * @author GF
 * @since 2022/7/13
 */
public class A0028Strstr02 {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int[] next = next(needle);

        int hLen = haystack.length(), nLen = needle.length();

        int hIndex = 0, nIndex = 0;

        while (hIndex < hLen && nIndex < nLen) {
            if (nIndex == -1 || haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                hIndex++;
                nIndex++;
                if (nIndex == nLen) {
                    return hIndex - nIndex;
                }
            } else {
                nIndex = next[nIndex];
            }
        }
        return -1;
    }


    public int[] next(String pattern) {
        final char[] p = pattern.toCharArray();
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int index = 0;
        int jump = -1;
        while (index < pattern.length() - 1) {
            if (jump == -1 || p[jump] == p[index]) {
                next[++index] = ++jump;
            } else {
                jump = next[jump];
            }
        }
        return next;
    }


    public static void main(String[] args) {
        String a = "abcdefg";
        String b = "def";
        String c = "bce";
        String d = "a";
        A0028Strstr02 instance = new A0028Strstr02();
        System.out.println(instance.strStr(a, b));
//        System.out.println(instance.strStr(a, c));
//        System.out.println(instance.strStr(a, d));
    }

}
