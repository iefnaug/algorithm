package com.algorithm.hash;

/**
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次
 *
 * <a href="https://leetcode.cn/problems/valid-sudoku">algorithm</a>
 */
public class A0036ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int [9][9];
        int[][] cols = new int [9][9];
        int[][][] box = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    cols[j][index]++;
                    box[i/3][j/3][index]++;
                    if (rows[i][index] > 1 || cols[j][index] > 1 || box[i/3][j/3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
