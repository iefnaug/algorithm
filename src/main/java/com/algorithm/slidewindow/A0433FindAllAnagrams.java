package com.algorithm.slidewindow;

import java.util.*;

/**
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 
 *
 * 示例1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s和p仅包含小写字母
 *
 */
public class A0433FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return resultList;
        }
        int[] sc = new int[26];
        int[] pc = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sc[s.charAt(i) - 'a'];
            ++pc[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sc, pc)) {
            resultList.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            --sc[s.charAt(i) - 'a'];
            ++sc[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sc, pc)) {
                resultList.add(i + 1);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        A0433FindAllAnagrams algorithm = new A0433FindAllAnagrams();
        List<Integer> resultList = algorithm.findAnagrams("cbaebabacd", "abc");
        resultList.forEach(System.out::println);
    }

}
