package com.algorithm.sort;

/*
 * @author GF
 * @since 2022/9/21
 */
public class Offer51ReversePair {

    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return sortAndCount(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private int sortAndCount(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = sortAndCount(nums, left, mid, tmp);
        int rightCount = sortAndCount(nums, mid + 1, right, tmp);
        final int crossCount = mergeAndCount(nums, left, mid, right, tmp);
        return leftCount + rightCount + crossCount;
    }

    /**
     * 合并阶段 本质上是 合并两个排序数组 的过程，
     * 而每当遇到 左子数组当前元素 > 右子数组当前元素 时，
     * 意味着 「左子数组当前元素 至 末尾元素」 与 「右子数组当前元素」 构成了若干 「逆序对」
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        int count = 0;
        int m = left, n = mid + 1, k = 0;
        while (m <= mid && n <= right) {
            if (nums[m] <= nums[n]) {
                tmp[k++] = nums[m++];
            } else {
                count += (mid - m + 1);
                tmp[k++] = nums[n++];
            }
        }
        while (m <= mid) {
            tmp[k++] = nums[m++];
        }
        while (n <= right) {
            tmp[k++] = nums[n++];
        }
        k = 0;
        while (left <= right) {
            nums[left++] = tmp[k++];
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {
                1,5,7,8,4,6,9,10,2
        };
        Offer51ReversePair reversePair = new Offer51ReversePair();
        final int count = reversePair.reversePairs(nums);
        System.out.println(count);
    }

}
