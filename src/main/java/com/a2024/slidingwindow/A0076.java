package com.a2024.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

 注意：

 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 如果 s 中存在这样的子串，我们保证它是唯一的答案。


 示例 1：

 输入：s = "ADOBECODEBANC", t = "ABC"
 输出："BANC"
 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 示例 2：

 输入：s = "a", t = "a"
 输出："a"
 解释：整个字符串 s 是最小覆盖子串。
 示例 3:

 输入: s = "a", t = "aa"
 输出: ""
 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 因此没有符合条件的子字符串，返回空字符串。


 提示：

 m == s.length
 n == t.length
 1 <= m, n <= 10^5
 s 和 t 由英文字母组成


 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 *
 * @author gf01867832
 * @since 2024/6/11
 */
public class A0076 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> seekMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (targetMap.containsKey(t.charAt(i))) {
                targetMap.put(t.charAt(i), targetMap.get(t.charAt(i)) + 1);
            } else {
                targetMap.put(t.charAt(i), 1);
            }
        }

        String result = "";
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            if (seekMap.containsKey(s.charAt(fast))) {
                seekMap.put(s.charAt(fast), seekMap.get(s.charAt(fast)) + 1);
            } else {
                seekMap.put(s.charAt(fast), 1);
            }
            while (slow <= fast && check(seekMap, targetMap)) {
                if (result.isEmpty()) {
                    result = s.substring(slow, fast + 1);
                } else {
                    result = result.length() < fast - slow + 1 ? result : s.substring(slow, fast + 1);
                }
                if (seekMap.get(s.charAt(slow)) > 1) {
                    seekMap.put(s.charAt(slow), seekMap.get(s.charAt(slow)) - 1);
                } else {
                    seekMap.remove(s.charAt(slow));
                }
                slow++;
            }
            fast++;
        }
        return result;
    }

    private boolean check(Map<Character, Integer> seekMap, Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (Objects.isNull(seekMap.get(entry.getKey())) || entry.getValue() > seekMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        A0076 algorithm = new A0076();
        String result = algorithm.minWindow(s, t);
        System.out.println(result);
    }
}
