package com.algorithm.array;

/*
给定一个数组A，将其划分为两个连续子数组left和right，使得：

left中的每个元素都小于或等于right中的每个元素。
left 和right都是非空的。
left 的长度要尽可能小。
在完成这样的分组后返回left的长度。可以保证存在这样的划分方法。



示例 1：

输入：[5,0,3,8,6]
输出：3
解释：left = [5,0,3]，right = [8,6]
示例 2：

输入：[1,1,1,0,6,12]
输出：4
解释：left = [1,1,1,0]，right = [6,12]


提示：

2 <= A.length<= 30000
0 <= A[i] <= 10^6
可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals

 * @author GF
 * @since 2021/9/15
 */
public class A0915PartitionArrayIntoDisjointIntervals {


    public static int partitionDisjoint(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int[] leftMax = new int[nums.length];
        leftMax[0] = nums[0];
        int lm = leftMax[0];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(nums[i], lm);
            lm = leftMax[i];
        }

        int[] rightMin = new int[nums.length];
        rightMin[rightMin.length - 2] = nums[nums.length - 1];
        int rm = rightMin[rightMin.length - 2];
        for (int i = nums.length - 3; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i+1], rm);
            rm = rightMin[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (leftMax[i] <= rightMin[i]) {
                return i + 1;
            }
        }
        return 0;
    }



    public static void main(String[] args) {
//        int[] nums = new int[] {5,0,3,8,6};
        int[] nums = new int[] {1,1,1,0,6,12};
        System.out.println(partitionDisjoint(nums));
    }

}
