package com.a2024.dfsbfs;

import java.util.LinkedList;
import java.util.List;

/**
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



 示例 1：

 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]
 示例 2：

 输入：n = 1
 输出：["()"]


 提示：

 1 <= n <= 8
 */
public class A0022 {

    public List<String> generateParenthesis(int n) {
        LinkedList<String> list = new LinkedList<>();
        generate(list, n, n, new StringBuilder());
        return list;
    }

    void generate(List<String> resultList, int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            resultList.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            generate(resultList, left - 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0) {
            if (right > left) {
                sb.append(")");
                generate(resultList, left, right - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        A0022 algorithm = new A0022();
        List<String> list = algorithm.generateParenthesis(3);
        list.forEach(System.out::println);

    }

}
