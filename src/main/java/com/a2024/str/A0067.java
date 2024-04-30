package com.a2024.str;

/**

 67. 二进制求和

 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。

 示例 1：

 输入:a = "11", b = "1"
 输出："100"
 示例 2：

 输入：a = "1010", b = "1011"
 输出："10101"


 提示：

 1 <= a.length, b.length <= 104
 a 和 b 仅由字符 '0' 或 '1' 组成
 字符串如果不是 "0" ，就不含前导零


 * @author iefnaug
 * @since 2024/4/30
 */
public class A0067 {

    public String addBinary(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        StringBuilder result = new StringBuilder();
        int aIndex = aCharArray.length - 1, bIndex = bCharArray.length - 1, add = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            int sum =
                    (aIndex >= 0 ? (aCharArray[aIndex] - '0') : 0) +
                    (bIndex >= 0 ? (bCharArray[bIndex] - '0') : 0) +
                    add;
            if (sum >= 2) {
                sum -= 2;
                add = 1;
            } else {
                add = 0;
            }
            //头部插入，影响效率
            result.insert(0, sum);
            aIndex--;
            bIndex--;
        }
        if (add > 0) {
            result.insert(0, add);
        }
        return result.toString();
    }

    public String addBinary2(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        int aIndex = aCharArray.length - 1, bIndex = bCharArray.length - 1, add = 0;
        char[] result = new char[Math.max(aIndex, bIndex) + 2];
        int resultIndex = result.length - 1;
        while (aIndex >= 0 || bIndex >= 0) {
            int sum =
                    (aIndex >= 0 ? (aCharArray[aIndex] - '0') : 0) +
                    (bIndex >= 0 ? (bCharArray[bIndex] - '0') : 0) +
                    add;
            if (sum >= 2) {
                sum -= 2;
                add = 1;
            } else {
                add = 0;
            }
            result[resultIndex--] = (char) (sum + '0');
            aIndex--;
            bIndex--;
        }
        if (add > 0) {
            result[resultIndex--] = (char) (add + '0');
        }
        return new String(result, resultIndex + 1, result.length - resultIndex - 1);
    }


    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        A0067 algorithm = new A0067();
//        String result = algorithm.addBinary(a, b);
        String result = algorithm.addBinary2(a, b);
        System.out.println(result);
    }
}
