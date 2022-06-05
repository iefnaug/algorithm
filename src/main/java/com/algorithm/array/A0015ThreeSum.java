package com.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author GF
 * @since 2022/6/3
 */
public class A0015ThreeSum {

    /**
     * O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return resultList;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while (left < nums.length && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if (target < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return resultList;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {
                -1, -1, 0,1,2,-1,-4, 2, 2
        };
        A0015ThreeSum threeSum = new A0015ThreeSum();
        final List<List<Integer>> lists = threeSum.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.get(0) + ", " + list.get(1) + ", " + list.get(2));
        }
    }

}
