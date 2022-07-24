package com.algorithm.str;

/**
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = " hello world "
 * 输出："world hello"
 * 解释：颠倒后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 *
 * 输入：s = "a good  example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 * @author GF
 * @since 2022/7/24
 */
public class A0151ReverseWords {

    public String reverseWords(String s) {
        char[] c = reverse(s);
        StringBuilder builder = new StringBuilder();
        int left = 0, right = 0;
        while (right < c.length) {
            if (c[left] == ' ') {
                left++;
                right++;
            } else if (c[right] == ' ') {
                reverseWord(builder, left, right - 1, c);
                while (right < c.length && c[right] == ' ') {
                    right++;
                }
                left = right;
            } else if (c[right] != ' ') {
                if (right == c.length - 1) {
                    reverseWord(builder, left, right, c);
                    break;
                }
                right++;

            }
        }
        return builder.toString();
    }

    private void reverseWord(StringBuilder builder, int left, int right, char[] c) {
        if (builder.length() != 0) {
            builder.append(' ');
        }
        for (int i = right; i >= left; i--) {
            builder.append(c[i]);
        }
    }

    private char[] reverse(String s) {
        final char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;
        while (left < right) {
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left++;
            right--;
        }
        return c;
    }

    public static void main(String[] args) {
//        String str = " hello world hou4e many2many     test";
        String str = "the sky is blue";
        A0151ReverseWords algorithm = new A0151ReverseWords();
        System.out.println(algorithm.reverseWords(str));
    }

}
