package com.algorithm.bfsdfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * <a href="https://leetcode.cn/problems/generate-parentheses">algorithm</a>
 */
public class A0022GenerateParentheses {

    /**
     * 当前已出现的左空号数量n1，右括号数量n2，必须满足n1 >= n2
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(new char[2 * n], 0, 0, 0, result);
        return result;
    }

    private void generate(char[] combination, int cur, int left, int right, List<String> result) {
        if (cur == combination.length) {
            if (valid(combination)) {
                result.add(new String(combination));
            }
        } else {
            if (left < combination.length / 2) {
                if (left < right) {
                    return;
                }
                combination[cur] = '(';
                generate(combination, cur + 1, left + 1, right, result);

            }

            if (right < combination.length / 2) {
                combination[cur] = ')';
                generate(combination, cur + 1, left, right + 1, result);
            }

        }
    }

    private boolean valid(char[] combination) {
        int balance = 0;
        for (char c : combination) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    public static void main(String[] args) {
        A0022GenerateParentheses algorithm = new A0022GenerateParentheses();
        List<String> result = algorithm.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }

    }

}
