package com.algorithm.str;

import java.util.ArrayList;
import java.util.List;

public class ExtractVariables {

    public String[] extract(String content) {
        List<String> result = new ArrayList<>();
        if (content == null || content.length() < 5) {
            return result.toArray(new String[]{});
        }
        int len = content.length();
        int cur = 0, next = 1;
        int headIndex = -1, tailIndex = -1;
        while (next < len) {
            while (next < len) {
                if (content.charAt(cur) != '&' || content.charAt(next) != '&') {
                    cur++;
                    next++;
                } else {
                    while (next + 1 < len && content.charAt(next + 1) == '&') {
                        cur++;
                        next++;
                    }
                    headIndex = next + 1;
                    cur += 2;
                    next += 2;
                    break;
                }
            }
            while (headIndex > 0 && next < len) {
                if (content.charAt(cur) != '&' || content.charAt(next) != '&') {
                    cur++;
                    next++;
                } else {
                    tailIndex = cur - 1;
                    break;
                }
            }
            if (headIndex > 0 && headIndex <= tailIndex) {
                result.add(content.substring(headIndex, tailIndex + 1));
                cur += 2;
                next += 2;
                headIndex = tailIndex = -1;
            }
        }
        return result.toArray(new String[]{});
    }

    public static void main(String[] args) {
        String content = "abc&&efg&&&&&hijk&&lmn";
//        String content = "abc&&&&lmn";
//        String content = "a&aa&&aaa&&bbb";
        ExtractVariables find = new ExtractVariables();
        String[] result = find.extract(content);
        for (String s : result) {
            System.out.println(s);
        }
    }

}
