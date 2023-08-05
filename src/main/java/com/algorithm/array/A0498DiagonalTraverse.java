package com.algorithm.array;

import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 * @author GF
 * @since 2023/8/4
 */
public class A0498DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int total = m * n;
        int[] result = new int[total];
        int count = 0;
        int i = 0, j = 0, direction = 1;
        while (count < total) {
            result[count++] = mat[i][j];
            if (direction == 1 && i - 1 < 0) {
                if (j + 1 == n) {
                    i = i + 1;
                } else {
                    j = j + 1;
                }
                direction = -1;
                continue;
            }

            if (direction == 1 && j + 1 == n) {
                i = i + 1;
                direction = -1;
                continue;
            }

            if (direction == -1 && j - 1 < 0) {
                if (i + 1 == m) {
                    j = j + 1;
                } else {
                    i = i + 1;
                }
                direction = 1;
                continue;
            }

            if (direction == -1 && i + 1 == m) {
                j = j + 1;
                direction = 1;
                continue;
            }

            if (direction == 1) {
                i = i -1;
                j = j + 1;
            } else {
                i = i + 1;
                j = j - 1;
            }
        }
        return result;
    }



    public int[] findDiagonalOrder2(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int total = m * n;
        int[] result = new int[total];
        int count = 0;
        int i = 0, j = 0;
        boolean direction = true;
        while (count < total) {
            result[count++] = mat[i][j];
            if (direction) {
                if (j + 1 == n) {
                    i++;
                    direction = false;
                } else if (i - 1 < 0) {
                    j++;
                    direction = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i + 1 == m) {
                    j++;
                    direction = true;
                } else if (j - 1 < 0) {
                    i++;
                    direction = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        A0498DiagonalTraverse algorithm = new A0498DiagonalTraverse();
//        int[] diagonalOrder = algorithm.findDiagonalOrder(mat);
        int[] diagonalOrder = algorithm.findDiagonalOrder2(mat);
        Arrays.stream(diagonalOrder).forEach(ele -> System.out.print(ele + ", "));
    }

}
