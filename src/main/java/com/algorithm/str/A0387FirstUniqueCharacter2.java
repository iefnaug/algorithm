package com.algorithm.str;

/**
 * 给定一个字符串s，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1。
 *
 * 
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 * 
 *
 * 提示:
 *
 * 1 <= s.length <= 10^5
 * s 只包含小写字母
 */
public class A0387FirstUniqueCharacter2 {


    public int firstUniqChar(String s) {
        //record[n][0]记录第一次出现的索引  record[n][1]记录出现的次数
        int[][] record = new int[26][2];
        for (int i = 0; i < record.length; i++) {
            record[i][0] = -1;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            if (record[index][0] == -1) {
                record[index][0] = i;
                record[index][1] = 1;
            } else {
                record[index][1] += 1;
            }
        }
        int resultIndex = Integer.MAX_VALUE;
        for (int[] pair : record) {
            if (pair[1] == 1) {
                resultIndex = Math.min(resultIndex, pair[0]);
            }
        }
        return resultIndex == Integer.MAX_VALUE ? -1 : resultIndex;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        A0387FirstUniqueCharacter2 algorithm = new A0387FirstUniqueCharacter2();
        System.out.println(algorithm.firstUniqChar(str));
    }

}
