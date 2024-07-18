package com.a2024.dfsbfs;

import java.util.LinkedList;
import java.util.List;

/**
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 示例 1：

 输入：digits = "23"
 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 示例 2：

 输入：digits = ""
 输出：[]
 示例 3：

 输入：digits = "2"
 输出：["a","b","c"]
 */
public class A0017 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, int i, StringBuilder sb, List<String> res) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char[] chars = getChars(digits.charAt(i));
        for (char c : chars) {
            sb.append(c);
            backtrack(digits, i + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    private char[] getChars(char num) {
        switch (num) {
            case '2': return new char[]{'a', 'b', 'c'};
            case '3': return new char[]{'d', 'e', 'f'};
            case '4': return new char[]{'g', 'h', 'i'};
            case '5': return new char[]{'j', 'k', 'l'};
            case '6': return new char[]{'m', 'n', 'o'};
            case '7': return new char[]{'p', 'q', 'r', 's'};
            case '8': return new char[]{'t', 'u', 'v'};
            case '9': return new char[]{'w', 'x', 'y', 'z'};
            default: return new char[]{};
        }
    }


    public static void main(String[] args) {
        A0017 a0017 = new A0017();
        List<String> resultList = a0017.letterCombinations("23");
        resultList.forEach(System.out::println);
    }
}
