package com.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 0 <= rowIndex <= 33
 * @author GF
 * @since 2023/5/25
 */
public class A0119PascalsTriangleII {


    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            list.add(1);
            return list;
        } else if (rowIndex == 1) {
            list.add(1);
            list.add(1);
            return list;
        }
        list.add(1);
        list.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            int pre = list.get(0);
            for (int j = 1; j <= i - 1; j++) {
                int cur = list.get(j);
                list.set(j, cur + pre);
                pre = cur;
            }
            list.set(0, 1);
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        A0119PascalsTriangleII algorithm = new A0119PascalsTriangleII();
        List<Integer> list = algorithm.getRow(5);
        list.forEach(each -> System.out.println(each + ", "));
    }

}
