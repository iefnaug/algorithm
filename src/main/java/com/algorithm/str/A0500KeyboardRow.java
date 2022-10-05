package com.algorithm.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘 中：
 *
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 * <a href="https://leetcode.cn/problems/keyboard-row">algorithm</a>
 *
 * @author GF
 * @since 2022/10/5
 */
public class A0500KeyboardRow {

    public String[] findWords(String[] words) {
        String firstLine = "qwertyuiop";
        String secondLine = "asdfghjkl";
        String thirdLine = "zxcvbnm";

        Set<Character> firstSet = new HashSet<>();
        for (char c : firstLine.toCharArray()) {
            firstSet.add(c);
        }

        Set<Character> secondSet = new HashSet<>();
        for (char c : secondLine.toCharArray()) {
            secondSet.add(c);
        }

        Set<Character> thirdSet = new HashSet<>();
        for (char c : thirdLine.toCharArray()) {
            thirdSet.add(c);
        }

        Set<Character> target;
        List<String> answerList = new ArrayList<>();

        for (String word : words) {
            final char[] chars = word.toLowerCase().toCharArray();
            if (firstSet.contains(chars[0])) {
                target = firstSet;
            } else if (secondSet.contains(chars[0])) {
                target = secondSet;
            } else if (thirdSet.contains(chars[0])) {
                target = thirdSet;
            } else {
                throw new RuntimeException();
            }
            boolean success = true;
            for (int i = 1; i < chars.length; i++) {
                if (!target.contains(chars[i])) {
                    success = false;
                    break;
                }
            }
            if (success) {
                answerList.add(word);
            }
        }
        return answerList.toArray(new String[0]);
    }


    public String[] findWords2(String[] words) {
        List<String> list = new ArrayList<String>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        String words[] = {"Hello","Alaska","Dad","Peace"};
        A0500KeyboardRow algorithm = new A0500KeyboardRow();
        final String[] answer = algorithm.findWords2(words);
        for (String s : answer) {
            System.out.println(s);
        }
    }

}
