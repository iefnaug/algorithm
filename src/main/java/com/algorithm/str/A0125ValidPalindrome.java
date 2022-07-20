package com.algorithm.str;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 2 ^ 105
 * 字符串 s 由 ASCII 字符组成
 *
 *  @author GF
 * @since 2022/7/20
 */
public class A0125ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        final char[] charArray = s.toCharArray();
        while (left < right) {
            final char leftChar = charArray[left];
            final char rightChar = charArray[right];
            if (inRange(leftChar) && inRange(rightChar)) {
                if (leftChar != rightChar) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            } else if (inRange(leftChar) && !inRange(rightChar)) {
                right--;
            } else {
                left++;
            }
        }
        return true;
    }

    private boolean inRange(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
//        System.out.println((int)'a'); //97
//        System.out.println((int)'A'); // 65
//        System.out.println((int)'0'); //48
//        System.out.println((int)'9'); //57

        A0125ValidPalindrome algorithm = new A0125ValidPalindrome();

//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        final boolean result = algorithm.isPalindrome(s);
        System.out.println(result);
    }

}
