package com.algorithm.segmenttree;

/*
 * @author GF
 * @since 2022/9/18
 */
public class A0303NumArray {

    private int[] nums;

    public A0303NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
