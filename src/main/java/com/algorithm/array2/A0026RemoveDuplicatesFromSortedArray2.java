package com.algorithm.array2;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 已按 升序 排列
 *
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array">algorithm</a>
 * @author GF
 * @since 2022/9/27
 */
public class A0026RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0;fast < nums.length; fast++) {
            if (fast == 0 || nums[fast] > nums[fast-1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,2,3,3,4,4,4,5,6,7,7
        };
        A0026RemoveDuplicatesFromSortedArray2 algorithm = new A0026RemoveDuplicatesFromSortedArray2();
        final int len = algorithm.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

}
