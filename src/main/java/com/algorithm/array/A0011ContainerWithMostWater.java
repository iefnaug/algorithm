package com.algorithm.array;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * @author GF
 * @since 2022/5/28
 */
public class A0011ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while(left < right) {
            int tmpArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, tmpArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {
                1,8,6,2,5,4,8,3,7
        };
        final int area = new A0011ContainerWithMostWater().maxArea(height);
        System.out.println(area);
    }

}
