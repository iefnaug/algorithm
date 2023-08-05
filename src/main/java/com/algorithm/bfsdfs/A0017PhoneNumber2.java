package com.algorithm.bfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number">algorithm</a>
 */
public class A0017PhoneNumber2 {

    private static Map<Character, String> PHONE_MAP = new HashMap<>();

    {
        PHONE_MAP.put('2', "abc");
        PHONE_MAP.put('3', "def");
        PHONE_MAP.put('4', "ghi");
        PHONE_MAP.put('5', "jkl");
        PHONE_MAP.put('6', "mno");
        PHONE_MAP.put('7', "pqrs");
        PHONE_MAP.put('8', "tuv");
        PHONE_MAP.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        dfs(list, digits, 0, new StringBuilder());
        return list;
    }

    private void dfs(List<String> list, String digits, int depth, StringBuilder preLevelStr) {
        if (depth >= digits.length()) {
            list.add(preLevelStr.toString());
            return;
        }
        String str = PHONE_MAP.get(digits.charAt(depth));
        for (int i = 0; i < str.length(); i++) {
            preLevelStr.append(str.charAt(i));
            dfs(list, digits, depth + 1, preLevelStr);
            preLevelStr.deleteCharAt(depth);
        }
    }


    public static void main(String[] args) {
        String digits = "234";
        A0017PhoneNumber2 algorithm = new A0017PhoneNumber2();
        List<String> result = algorithm.letterCombinations(digits);
        for (String s : result) {
            System.out.println(s);
        }
    }


}
