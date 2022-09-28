package com.algorithm.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 *
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 *
 * 
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输入:1
 * 
 *
 * 提示:
 *
 * 1 <= s.length <= 2000
 * s只由小写 和/或 大写英文字母组成
 *
 * <a href="https://leetcode.cn/problems/longest-palindrome">algorithm</a>
 *
 * @author GF
 * @since 2022/9/27
 */
public class A0409LongestPalindrome {

    public int longestPalindrome(String s) {
        final char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char each : c) {
            map.merge(each, 1, Integer::sum);
        }
        int count = 0;
        boolean hasOdd = false;
        final Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            final Integer value = entry.getValue();
            if (value % 2 == 1) {
                hasOdd = true;
                if (value > 1) {
                    count += (value - 1);
                }
            } else {
                count += value;
            }
        }
        return hasOdd ? count + 1 : count;
    }

    public static void main(String[] args) {
        A0409LongestPalindrome algorithm = new A0409LongestPalindrome();
        final int count = algorithm.longestPalindrome("aaabbccessqp");
        System.out.println(count);

    }

}
