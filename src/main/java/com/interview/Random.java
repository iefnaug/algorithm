package com.interview;

import java.util.*;

/**
 * @author GF
 * @since 2023/8/2
 */
public class Random {


    public static List<Integer> discountAndSort(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(a -> a));
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1,3,5,7,9,3,5,10,8,6
        };
        List<Integer> list = discountAndSort(nums);
        list.forEach(System.out::println);
    }

}
