package com.algorithm.array;

import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 输入：mat =
 * [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]
 *  ]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * @author GF
 * @since 2023/4/30
 */
public class A0489DiagonalTraverse {


    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length, direction = 1;
        int[] sequence = new int[rows * cols];
        int r = 0, c = 0;
        int count = 0;
        while (count < sequence.length) {
            sequence[count++] = mat[r][c];
            if (direction == 1) { //右上方向
//                if (r - 1 < 0 && c + 1 == cols) {
//                    r += 1;
//                    direction =  -1;
//                } else  if (r - 1 < 0) {
//                    c += 1;
//                    direction = -1;
//                } else if (c + 1 == cols){
//                    r += 1;
//                    direction = -1;
//                } else {
//                    r -= 1;
//                    c += 1;
//                }
                if (c + 1 == cols) {
                    r += 1;
                    direction =  -1;
                } else  if (r - 1 < 0) {
                    c += 1;
                    direction = -1;
                }  else {
                    r -= 1;
                    c += 1;
                }
            } else { //左下方向
//                if (r + 1 == rows && c - 1 < 0) {
//                    c += 1;
//                    direction = 1;
//                } else if (r + 1 == rows) {
//                    c += 1;
//                    direction = 1;
//                } else if (c - 1 < 0) {
//                    r += 1;
//                    direction = 1;
//                } else  {
//                    r += 1;//                    c -= 1;
//                }
                if (r + 1 == rows) {
                    c += 1;
                    direction = 1;
                } else if (c - 1 < 0) {
                    r += 1;
                    direction = 1;
                } else  {
                    r += 1;
                    c -= 1;
                }
            }
        }
        return sequence;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        A0489DiagonalTraverse algorithm = new A0489DiagonalTraverse();
        int[] diagonalOrder = algorithm.findDiagonalOrder(mat);
        for (int i : diagonalOrder) {
            System.out.print(i + ",");
        }
    }

}


