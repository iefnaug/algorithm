package com.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）
 *
 * <a href="https://leetcode.cn/problems/4sum>algorithm</a>
 * @author GF
 * @since 2022/9/24
 */
public class A0018FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answerList = new ArrayList<>();
        int length = nums.length;
        if (length < 4) {
            return answerList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if ((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                int left = j, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        if (nums[i] < nums[j] && nums[j] < nums[left] && nums[left] < nums[right]) {
                            answerList.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        } else {
                            left++;
                            right--;
                        }
                        while (left < length && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return answerList;
    }

    public static void main(String[] args) {
        int[] nums = {
//                -1, 0, 2, 3, 4, 7
//                1000000000,1000000000,1000000000,1_000_000_000 //4b溢出
//                0,0,0,0
                -3,-1,0,2,4,5
        };
        A0018FourSum algorithm = new A0018FourSum();
//        final List<List<Integer>> answerList = algorithm.fourSum(nums, 9);
//        final List<List<Integer>> answerList = algorithm.fourSum(nums, -294_967_296);
//        final List<List<Integer>> answerList = algorithm.fourSum(nums, 0);
        final List<List<Integer>> answerList = algorithm.fourSum(nums, 0);
        for (List<Integer> answer : answerList) {
            for (Integer num : answer) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }

}
