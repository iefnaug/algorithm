package com.algorithm.array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * <a href="https://leetcode.cn/problems/3sum>algorithm</a>
 *
 * @author GF
 * @since 2022/9/22
 */
public class A0015ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) {
            return resultList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target == 0) {
                    resultList.add(List.of(nums[i], nums[left++], nums[right--]));
                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (target > 0) {
                    right--;
                } else {
                    left++;
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
