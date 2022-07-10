package com.algorithm.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 *
 *
 * @author GF
 * @since 2022/7/10
 */
public class A0013RomanToInt {


    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        char unit = 'I';
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            final Integer preValue = romanMap.get(unit);
            final Integer curValue = romanMap.get(s.charAt(i));
            if (curValue >= preValue) {
                sum += curValue;
                unit = s.charAt(i);
            } else {
                sum -= curValue;
            }
        }
        return sum;
    }


    public int romanToInt2(String s) {
        char unit = 'I';
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            final int preValue = getValue(unit);
            final int curValue = getValue(s.charAt(i));
            if (curValue >= preValue) {
                sum += curValue;
                unit = s.charAt(i);
            } else {
                sum -= curValue;
            }
        }
        return sum;
    }


    private int getValue(char roman) {
        if ('I' == roman) {
            return 1;
        } else if ('V' == roman) {
            return 5;
        } else if ('X' == roman) {
            return 10;
        } else if ('L' == roman) {
            return 50;
        } else if ('C' == roman) {
            return 100;
        } else if ('D' == roman) {
            return 500;
        } else if ('M' == roman) {
            return 1000;
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        A0013RomanToInt romanToInt = new A0013RomanToInt();
        final int result = romanToInt.romanToInt2("MCMXCIV");
        System.out.println(result);
    }

}
