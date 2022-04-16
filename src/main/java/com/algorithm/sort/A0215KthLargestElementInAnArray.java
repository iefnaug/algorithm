package com.algorithm.sort;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第k个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * -104<= nums[i] <= 104
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */
public class A0215KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;
        return quickSort(nums, 0, nums.length - 1, kth);
    }

    private int quickSort(int[] nums, int left, int right, int kth) {
        int i = left, j = right;
        int target = nums[i];
        if (i < j) {
            while (i < j) {
                while (nums[j] >= target && i < j) {
                    j--;
                }
                nums[i] = nums[j];
                while (nums[i] < target && i < j) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = target;
            if (i == kth) {
                return target;
            }
            if (i < kth) {
                return quickSort(nums, i + 1, right, kth);
            } else {
                return quickSort(nums, left, i - 1, kth);
            }
        }
        return target;
    }

    public static void main(String[] args) {
        A0215KthLargestElementInAnArray a0215KthLargestElementInAnArray = new A0215KthLargestElementInAnArray();
        int[] nums = new int[]{
          1,3,5,7,9,2,4,6,8,10
        };
        final int result = a0215KthLargestElementInAnArray.findKthLargest(nums, 2);
        System.out.println(result);
    }
}
