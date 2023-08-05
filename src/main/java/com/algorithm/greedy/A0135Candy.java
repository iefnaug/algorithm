package com.algorithm.greedy;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 *
 * 提示：
 *
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 *
 * @author GF
 * @since 2023/8/3
 */
public class A0135Candy {

    /**
     * O(n)
     */
    public int candy(int[] ratings) {
        //left: 每个元素和自己左边比，满足条件的最小值
        int[] left = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        //right: 和自己右边比，满足条件的最小值
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i+1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }


    public int candy2(int[] ratings) {
        int result = 1, inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < ratings.length; i++) {
            //升序
            if (ratings[i] >= ratings[i-1]) {
                dec = 0;
                pre = ratings[i] == ratings[i-1] ? 1 : pre + 1;
                inc = pre;
                result += pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                result += dec;
                pre = 1;
            }
        }
        return result;
    }


}
