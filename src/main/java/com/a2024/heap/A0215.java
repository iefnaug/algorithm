package com.a2024.heap;


/**
 * 215. 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * @author gf01867832
 * @since 2024/4/29
 */
public class A0215 {


    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        int heapSize = nums.length;
        for (int i = 0; i < k - 1; i++) {
            nums[0] = nums[--heapSize];
            down(nums, 0, heapSize);
        }
        return nums[0];
    }


    public void buildHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            down(nums, i, nums.length);
        }
    }

    private void down(int[] nums, int i, int heapSize) {
        int parent = i, left = parent * 2 + 1, right = parent * 2 + 2;
        if (left < heapSize && nums[left] > nums[parent]) {
            parent = left;
        }
        if (right < heapSize && nums[right] > nums[parent]) {
            parent = right;
        }
        if (parent != i) {
            swap(nums, i, parent);
            down(nums, parent, heapSize);
        }
    }

    private void swap(int[] elements, int a, int b) {
        int tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

}
