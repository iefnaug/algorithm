package com.datastructure.sort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 希尔排序，一种改进的插入排序
 *
 * 希尔排序的思想是使数组中任意间隔为 h 的元素都是有序的。这样的数组被称为 h 有序数组。
 * 换句话说，一个 h 有序数组就是 h 个互相独立的有序数组编织在一起组成的一个数组。
 * 在进行排序时，如果 h 很大，我们就能将元素移动到很远的地方，为实现更小的 h 有序创造方便。
 * 当h=1时，
 *
 * @author GF
 * @since 2023/8/7
 */
public class HillSort {


    public static <T extends Comparable<T>> void sort(T[] g) {
        int len = g.length;
        int h = 1;
        while (h < len/3) {
            h = h * 3;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && g[j].compareTo(g[j-h]) < 0; j -= h) {
                    swap(g, j, j-h);
                }
            }
            h = h/3;
        }
    }

    private static <T extends Comparable<T>> void swap(T[] g, int a, int b) {
        T tmp = g[a];
        g[a] = g[b];
        g[b] = tmp;
    }


    public static void main(String[] args) {
        Integer[] nums = {
          1,3,5,7,9,2,4,6,8,0,22,66,88,33
        };
        HillSort.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
//        calculate(LocalDate.now(), 500, 1000, 0.015);
    }


    private static void calculate(LocalDate start, int period, double money, double rate) {
        StringBuilder builder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < period; i++) {
            String dateTime = start.format(formatter);
            start = start.plusDays(1);
            money = money * (1 + rate);
            builder.append(dateTime).append("  ").append(String.format("%.2f", money)).append("\n");
        }
        System.out.println(builder.toString());
    }

}
