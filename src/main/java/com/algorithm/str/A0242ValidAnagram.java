package com.algorithm.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 *  进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class A0242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if (sc.length != tc.length) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : sc) {
            map.merge(c, 1, Integer::sum);
        }
        for (char c : tc) {
            if (!map.containsKey(c)) {
                return false;
            }
            Integer count = map.get(c);
            if (count == 0) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        A0242ValidAnagram algorithm = new A0242ValidAnagram();
        boolean result = algorithm.isAnagram(s, t);
        System.out.println(result);
    }

}
