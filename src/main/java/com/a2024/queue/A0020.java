package com.a2024.queue;

import java.util.LinkedList;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 每个右括号都有一个对应的相同类型的左括号。


 示例 1：

 输入：s = "()"
 输出：true
 示例 2：

 输入：s = "()[]{}"
 输出：true
 示例 3：

 输入：s = "(]"
 输出：false
 */
public class A0020 {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (isLeft(aChar)) {
                stack.add(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatch(stack.pollLast(), aChar)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(Character left, Character right) {
        return
                (left.equals('(') &&  right.equals(')')) ||
                (left.equals('[') &&  right.equals(']')) ||
                (left.equals('{') &&  right.equals('}'));
    }

    private boolean isLeft(Character c) {
        return c == '(' || c == '[' || c == '{';
    }

    public static void main(String[] args) {
        A0020 algorithm = new A0020();
//        boolean valid = algorithm.isValid("()[]{}");
        boolean valid = algorithm.isValid("([)]");
        System.out.println(valid);
    }


}
