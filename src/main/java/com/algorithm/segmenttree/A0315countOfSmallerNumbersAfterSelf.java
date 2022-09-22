package com.algorithm.segmenttree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0] 
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 *
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * <a href="https://leetcode.cn/problems/count-of-smaller-numbers-after-self">algorithm</a>
 * @author GF
 * @since 2022/9/18
 */
public class A0315countOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> countList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            countList.add(0);
        }
        int[] tmp = new int[nums.length];
        if (nums.length < 2) {
            return countList;
        }
        sort(nums, 0, nums.length - 1, tmp, countList);
        return countList;
    }

    private void sort(int[] nums, int left, int right, int[] tmp, List<Integer> countList) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(nums, left, mid, tmp, countList);
            sort(nums, mid + 1, right, tmp, countList);
            merge(nums, left, mid, right, tmp, countList);
        }
    }

    /**
     * TODO
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param tmp
     * @param countList
     */
    private void merge(int[] nums, int left, int mid, int right, int[] tmp, List<Integer> countList) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                for (int g = i; g <= mid; g++) {
                    countList.set(g, countList.get(g) + 1);
                }
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        k = 0;
        while (left <= right) {
            nums[left++] = tmp[k++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {
//                1,5,7,8,4,6,9,10,2
                2, 0, 1
        };
        A0315countOfSmallerNumbersAfterSelf algorithm = new A0315countOfSmallerNumbersAfterSelf();
        final List<Integer> countList = algorithm.countSmaller(nums);
        for (int i = 0; i < countList.size(); i++) {
            System.out.println(i + ": " + countList.get(i));
        }
    }

}
