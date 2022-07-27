package com.algorithm.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串s，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1。
 *
 * 
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 * 
 *
 * 提示:
 *
 * 1 <= s.length <= 10^5
 * s 只包含小写字母
 *
 * @author fly
 * @since 2022/7/27
 */
public class A0387FirstUniqueCharacter {


    public int firstUniqChar(String s) {
        final char[] c = new char[26];
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            final int index = s.charAt(i) - 'a';
            if (c[index] == 0) {
                list.add(s.charAt(i));
            }
            c[index] += 1;
        }

        for (Character character : list) {
            if (c[character - 'a'] == 1) {
                for (int j = 0; j < s.length(); j++) {
                    if (character == s.charAt(j)) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        A0387FirstUniqueCharacter algorithm = new A0387FirstUniqueCharacter();
        System.out.println(algorithm.firstUniqChar(str));
    }

}
