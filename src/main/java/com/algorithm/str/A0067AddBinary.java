package com.algorithm.str;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字1和0。
 *
 *
 *
 * 示例1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 *
 * @author GF
 * @since 2022/7/14
 */
public class A0067AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(), b.length()), flag = 0;
        for (int i = 0; i < len; i++) {
            flag += a.length() > i ? a.charAt(a.length() - 1 - i) - '0' : 0;
            flag += b.length() > i ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.append((char) (flag % 2 + '0'));
            flag /= 2;
        }

        if (flag > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }



    public static void main(String[] args) {
        String a = "1010";
        String b = "10101";
        A0067AddBinary a0067AddBinary = new A0067AddBinary();
        final String result = a0067AddBinary.addBinary(a, b);
        System.out.println(result);
    }

}
