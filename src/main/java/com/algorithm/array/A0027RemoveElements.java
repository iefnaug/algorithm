package com.algorithm.array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author GF
 * @since 2023/5/10
 */
public class A0027RemoveElements {

    public int removeElement(int[] nums, int val) {
        int newIndex = -1, index = 0;
        while (index < nums.length) {
            if (nums[index] != val) {
                nums[++newIndex] = nums[index];
            }
            index++;
        }
        return newIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {
            0,1,2,2,3,0,4,2
        };
        A0027RemoveElements algorithm = new A0027RemoveElements();
        int size = algorithm.removeElement(nums, 2);
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + ",");
        }
    }

}
