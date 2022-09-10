package com.algorithm.disjoint;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * @author GF
 * @since 2022/9/10
 */
public class A0130SurroundedRegions {

    public void solve(char[][] board) {
        final int x = board.length, y = board[0].length;
        for (int i = 0; i < x; i++) {
            dfs(board, i, 0);
            dfs(board, i, y - 1);
        }
        for (int i = 0; i < y; i++) {
            dfs(board, 0, i);
            dfs(board, x - 1, i);
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 深度优先遍历
     */
    private void dfs(char[][] board, int x, int y) {
        final int i = board.length, j = board[0].length;
        if (x < 0 || x >= i || y < 0 || y >= j || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'G';
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
    }

}
