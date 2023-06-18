package com.algorithm.array;

import java.util.Arrays;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author GF
 * @since 2023/4/26
 */
public class A0048RotateImage2 {

    /**
     * matrix[row][col] = matrix[col][n-row-1]
     */
    public void rotate(int[][] matrix) {
       int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < (rows + 1) / 2; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int r1 = i, c1 = j;
                int r2 = c1, c2 = rows - r1 - 1;
                int r3 = c2, c3 = rows - r2 - 1;
                int r4 = c3, c4 = rows - r3 - 1;
                int tmp = matrix[r1][c1];
                matrix[r1][c1] = matrix[r4][c4];
                matrix[r4][c4] = matrix[r3][c3];
                matrix[r3][c3] = matrix[r2][c2];
                matrix[r2][c2] = tmp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] nums = new int[][] {
            { 5, 1, 9,11},
            { 2, 4, 8,10},
            {13, 3, 6, 7},
            {15,14,12,16}
        };

        A0048RotateImage2 algorithm = new A0048RotateImage2();
        algorithm.rotate(nums);
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

}
