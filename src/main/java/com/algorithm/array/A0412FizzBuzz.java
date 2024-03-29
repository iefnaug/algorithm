package com.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 *
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 *
 * @author GF
 * @since 2023/11/7
 */
public class A0412FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> answerList = new ArrayList<>();
        if (n < 1) {
            return answerList;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                answerList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answerList.add("Fizz");
            } else if (i % 5 == 0) {
                answerList.add("Buzz");
            } else {
                answerList.add(i + "");
            }
        }
        return answerList;
    }

}
