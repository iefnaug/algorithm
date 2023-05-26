package com.algorithm.array;


/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 10^4
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 *
 * @author GF
 * @since 2023/5/26
 */
public class A0557ReverseStringIII {


//    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        int slow = 0, fast = 0, len = sb.length();
//        while (fast < len) {
//            while (slow < len) {
//                if (sb.charAt(slow) == ' ') {
//                    slow++;
//                    fast++;
//                } else {
//                    break;
//                }
//            }
//            while (fast < len && sb.charAt(fast) != ' ') {
//                fast++;
//            }
//            reverseWord(sb, slow, fast - 1);
//            slow = fast;
//        }
//        return sb.toString();
//    }
//
//    private void reverseWord(StringBuilder sb, int left, int right) {
//        while (left < right) {
//            char tmp = sb.charAt(left);
//            sb.setCharAt(left, sb.charAt(right));
//            sb.setCharAt(right, tmp);
//            left++;
//            right--;
//        }
//    }

    public String reverseWords(String s) {
        char[] sb = s.toCharArray();
        int slow = 0, fast = 0, len = sb.length;
        while (fast < len) {
            while (slow < len) {
                if (sb[slow] == ' ') {
                    slow++;
                    fast++;
                } else {
                    break;
                }
            }
            while (fast < len && sb[fast] != ' ') {
                fast++;
            }
            reverseWord(sb, slow, fast - 1);
            slow = fast;
        }
        return new String(sb);
    }

    private void reverseWord(char[] sb, int left, int right) {
        while (left < right) {
            char tmp = sb[left];
            sb[left] = sb[right];
            sb[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        A0557ReverseStringIII algorithm = new A0557ReverseStringIII();
        String s = algorithm.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }

}
