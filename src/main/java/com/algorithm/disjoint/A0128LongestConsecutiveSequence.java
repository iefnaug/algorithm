package com.algorithm.disjoint;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -10^9 <= nums[i] <= 10^9
 *
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence">algorithm</a>
 *
 * @author GF
 * @since 2022/9/7
 */
public class A0128LongestConsecutiveSequence {

    /**
     * 超时
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        quickSort(nums, 0, nums.length - 1);
        int resultLen = 0;
        int len = 0;
        int start = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (start + 1 == nums[i]) {
                start++;
                len++;
            } else {
                if (start == nums[i]) {
                    continue;
                }
                resultLen = Math.max(resultLen, len);
                start = nums[i];
                len = 1;
            }
        }
        return Math.max(resultLen, len);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int pivot = nums[i];
            while (i < j) {
                while (pivot <= nums[j] && i < j) {
                    j--;
                }
                nums[i] = nums[j];
                while (pivot > nums[i] && i < j) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = pivot;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    /**
     * hash
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> container = new HashSet<>();
        for (int num : nums) {
            container.add(num);
        }
        int len = 0;
        for (int num : nums) {
            if (!container.contains(num - 1)) {
                int curLen = 1;
                while (container.contains(num + 1)) {
                    curLen++;
                    num++;
                }
                len = Math.max(len, curLen);
            }
        }
        return len;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {
//                1,3,5,7,9,2,4,6,8
                1,3,5,7,9,2,6,8
//                1,2,0,1
        };
        A0128LongestConsecutiveSequence algorithm = new A0128LongestConsecutiveSequence();
//        algorithm.quickSort(nums, 0, nums.length - 1);
//        for (int num : nums) {
//            System.out.print(num + ",");
//        }

        final int len = algorithm.longestConsecutive(nums);
        System.out.println(len);
    }
    
}
