package com.algorithm.array;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author GF
 * @since 2023/5/5
 */
public class A0014LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int len = strs[0].length();
        if (len == 0 || strs.length == 1) return strs[0];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length()) {
                    return result.toString();
                }
                if (c != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[] {
                "abcef", "abced", "abc"
        };
        A0014LongestCommonPrefix algorithm = new A0014LongestCommonPrefix();
        String prefix = algorithm.longestCommonPrefix(strs);
        System.out.println(prefix);
    }

}
