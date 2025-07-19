package com.a2025.str;

/*
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。



示例 1:

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: nums = [2,3,0,1,4]
输出: 2


提示:

1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
题目保证可以到达 nums[n-1]
 */
public class A0045JumpGame2 {

    /**
     * 贪心 O(n^2)
     */
    public int jump(int[] nums) {
        int pos = nums.length - 1, step = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] + i >= pos) {
                    pos = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    /**
     * 依赖测试用例，测试用例必须有解
     */
    public int jump2(int[] nums) {
        int len = nums.length - 1;
        int end = 0, maxPosition = 0, step = 0;
        for (int i = 0; i < len; i++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

}
