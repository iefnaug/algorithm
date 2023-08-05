package com.algorithm.heap;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author GF
 * @since 2023/8/3
 */
public class A0215KthLargestElement {


    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        heapfiy(nums, heapSize);
        for(int i = nums.length - 1; i > nums.length - k; i--) {
            nums[0] = nums[i];
            down(nums, heapSize--, 0);
        }
        return nums[0];
    }

    /**
     * 构建大根堆
     */
    private void heapfiy(int[] nums, int heapSize) {
        for(int i = heapSize/2; i >= 0; i--) {
            down(nums, heapSize, i);
        }
    }

    /**
     * ps: 子节点的父节点计算 parent = (child - 1)/2
     */
    private void down(int[] nums, int heapSize, int parent) {
        int leftChild = parent * 2 + 1, rightChild = parent * 2 + 2;
        int max = parent;
        if (leftChild < heapSize && nums[leftChild] > nums[max]) {
            max = leftChild;
        }
        if (rightChild < heapSize && nums[rightChild] > nums[max]) {
            max = rightChild;
        }
        if (parent != max) {
            swap(nums, parent, max);
            down(nums, heapSize, max);
        }
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {
                3,2,3,1,2,4,5,5,6
        };
        A0215KthLargestElement algorithm = new A0215KthLargestElement();
        int result = algorithm.findKthLargest(nums, 4);
        System.out.println(result);
    }


}
