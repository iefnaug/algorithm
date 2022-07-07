package com.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 *
 * @author GF
 * @since 2022/7/7
 */
public class Offer48 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int right = -1, len = s.length(), result = 0;
        Set<Character> charSet = new HashSet<>();
        for (int left = 0; left < len; left++) {
            if (left != 0) {
                charSet.remove(s.charAt(left - 1));
            }
            while (right + 1 < len && !charSet.contains(s.charAt(right + 1))) {
                charSet.add(s.charAt(right + 1));
                right++;
            }
            result = Math.max(result, right - left + 1);
            if (right == len - 1) {
                return result;
            }
        }
        return  result;
    }



    public int lengthOfLongestSubstring2(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int right = -1, len = s.length(), result = 0;
        int[] arr = new int[128];
        for (int left = 0; left < len; left++) {
            if (left != 0) {
                arr[s.charAt(left - 1)]--;
            }
            while (right + 1 < len && arr[s.charAt(right + 1)] == 0) {
                arr[s.charAt(right + 1)]++;
                right++;
            }
            result = Math.max(result, right - left + 1);
            if (right == len - 1) {
                return result;
            }
        }
        return  result;
    }


    public static void main(String[] args) {
        String str = "qweqabqa";
        Offer48 offer48 = new Offer48();
        final int result = offer48.lengthOfLongestSubstring2(str);
        System.out.println(result);
    }



}
