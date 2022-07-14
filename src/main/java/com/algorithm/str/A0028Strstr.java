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
public class A0028Strstr {

    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length(), needleLen = needle.length();
        if (haystackLen < needleLen) {
            return -1;
        }

        for (int i = 0; i <= haystackLen - needleLen; i++) {
            int j = 0;
            for (; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needleLen) {
                return i;
            }
        }
        return -1;
    }


    public int kmp(String str, String target) {
        return 0;
    }

    /**
     * next[j]的值（也就是k）表示，当P[j] != T[i]时，j指针的下一步移动位置。
     */
    public static int[] getNext(String ps) {

        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < p.length - 1) {

            if (k == -1 || p[j] == p[k]) {

                next[++j] = ++k;

            } else {

                k = next[k];

            }

        }

        return next;

    }


    public static int KMP(String ts, String ps) {

        char[] t = ts.toCharArray();

        char[] p = ps.toCharArray();

        int i = 0; // 主串的位置

        int j = 0; // 模式串的位置

        int[] next = getNext(ps);

        while (i < t.length && j < p.length) {

            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0

                i++;

                j++;

            } else {

                // i不需要回溯了

                // i = i - j + 1;

                j = next[j]; // j回到指定位置

            }

        }

        if (j == p.length) {

            return i - j;

        } else {

            return -1;

        }

    }


    public static void main(String[] args) {
        String a = "abcdefg";
        String b = "def";
        String c = "bce";
        String d = "a";
        A0028Strstr instance = new A0028Strstr();
        System.out.println(instance.strStr(a, b));
        System.out.println(instance.strStr(a, c));
        System.out.println(instance.strStr(a, d));
    }

}
