package com.a2025.str;

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9


提示：

n == height.length
1 <= n <= 2 * 10^4
0 <= height[i] <= 10^5
 */

public class A0042TrappingRainWater {

    public int trap(int[] height) {
        int[] leftMaxHeight =  new int[height.length];
        leftMaxHeight[0] = 0;
        int leftMax = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i-1]);
            leftMaxHeight[i] = leftMax;
        }

        int[] rightMaxHeight = new  int[height.length];
        rightMaxHeight[height.length - 1] = 0;
        int maxRight = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i+1]);
            rightMaxHeight[i] = maxRight;
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            total += Math.max(Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i], 0);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] height = {
                4,2,0,3,2,5
        };
        A0042TrappingRainWater algo = new A0042TrappingRainWater();
        int result = algo.trap(height);
        System.out.println(result);
    }

}
