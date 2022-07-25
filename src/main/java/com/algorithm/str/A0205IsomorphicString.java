package com.algorithm.str;

import java.util.HashMap;
import java.util.Map;

/*
 * @author GF
 * @since 2022/7/25
 */
public class A0205IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }


    public static void main(String[] args) {
        final A0205IsomorphicString algorithm = new A0205IsomorphicString();
        String s = "paper";
        String t = "title";
        final boolean isomorphic = algorithm.isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

}
