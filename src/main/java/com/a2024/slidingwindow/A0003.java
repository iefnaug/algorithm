package com.a2024.slidingwindow;


import java.util.HashSet;
import java.util.Set;

/**
 3. 无重复字符的最长子串

 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 子串
 的长度。



 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 提示：

 0 <= s.length <= 5 * 10^4
 s 由英文字母、数字、符号和空格组成


 */
public class A0003 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 1, len = s.length(), max = 1;
        char[] charArray = s.toCharArray();
        set.add(charArray[0]);
        while (fast < len) {
            if (set.contains(charArray[fast])) {
                set.remove(charArray[slow++]);
            } else {
                set.add(charArray[fast++]);
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        A0003 algorithm = new A0003();
        int count = algorithm.lengthOfLongestSubstring(str);
        System.out.println(count);
    }

}
