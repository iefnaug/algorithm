package com.algorithm.str;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成
 *
 *
 * @author fly
 * @since 2022/7/26
 */
public class A0345ReverseVowels {

    public String reverseVowels(String s) {
        final char[] c = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            boolean leftIsVowel = isVowel(c[left]);
            boolean rightIsVowel = isVowel(c[right]);
            if (leftIsVowel && rightIsVowel) {
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
                left++;
                right--;
            } else if (!leftIsVowel) {
                left++;
            } else {
                right--;
            }
        }
        return new String(c);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String s = "leetcode";
        A0345ReverseVowels algorithm = new A0345ReverseVowels();
        System.out.println(algorithm.reverseVowels(s));
    }

}
