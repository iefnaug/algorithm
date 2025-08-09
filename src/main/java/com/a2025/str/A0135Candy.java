package com.a2025.str;

/*
n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

你需要按照以下要求，给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻两个孩子中，评分更高的那个会获得更多的糖果。
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。



示例 1：

输入：ratings = [1,0,2]
输出：5
解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
示例 2：

输入：ratings = [1,2,2]
输出：4
解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。


提示：

n == ratings.length
1 <= n <= 2 * 10^4
0 <= ratings[i] <= 2 * 10^4
 */
public class A0135Candy {

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int total = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i+1]) {
                left[i] = Math.max(left[i], left[i+1] + 1);
            }
            total += left[i];
        }
        return total;
    }

    public static void main(String[] args) {
        A0135Candy algo = new A0135Candy();
        int[] ratings = {1, 3, 2, 2, 1};
        int candy = algo.candy(ratings);
        System.out.println(candy);
    }

}
