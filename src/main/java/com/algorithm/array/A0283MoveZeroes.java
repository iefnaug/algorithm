package com.algorithm.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 * @author GF
 * @since 2023/5/26
 */
public class A0283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0, fast = 0;
        while (fast < len) {
            while (fast < len && nums[fast] == 0) {
                fast++;
            }
            if (fast == len) {
                break;
            }
            nums[slow++] = nums[fast++];
        }
        for (int i = slow; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,0,5,0,6,0,0,7};
        A0283MoveZeroes algorithm = new A0283MoveZeroes();
        algorithm.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

}
