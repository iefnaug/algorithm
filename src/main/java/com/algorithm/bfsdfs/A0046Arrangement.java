package com.algorithm.bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GF
 * @since 2023/8/24
 */
public class A0046Arrangement {


    public List<List<Integer>> arrange(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(resultList, list, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, List<Integer> list, int n) {
        if (n == list.size()) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i = n; i < list.size(); i++) {
            Collections.swap(list, i, n);
            backtrack(resultList, list, n + 1);
            Collections.swap(list, n, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        A0046Arrangement algorithm = new A0046Arrangement();
        List<List<Integer>> resultList = algorithm.arrange(nums);
        resultList.forEach(list -> {
            list.forEach(ele -> System.out.print(ele + ", "));
            System.out.println();
        });
    }

}
