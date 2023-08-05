package com.algorithm.bfsdfs;

import java.util.*;

/**
 * @author GF
 * @since 2023/8/3
 */
public class A0051NQueens {

    /**
     * N皇后问题
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList =  new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        int[] columns = new int[n];
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backTrack(resultList, queens, 0, columns, diagonals1, diagonals2);
        return resultList;
    }


    private void backTrack(List<List<String>> resultList, int[] queens, int row, int[] columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == queens.length) {
            //一轮深度遍历后可以放置
            resultList.add(generate(queens));
            return;
        }
        //开始从row行，i列放置皇后
        for (int i = 0; i < queens.length; i++) {
            //第i列放置过皇后
            if (columns[i] > 0) {
                continue;
            }
            //左上到右下对角线
            if (diagonals1.contains(row - i)) {
                continue;
            }
            //右上到左下对角线
            if (diagonals2.contains(row + i)) {
                continue;
            }
            columns[i] = 1;
            diagonals1.add(row - i);
            diagonals2.add(row + i);
            queens[row] = i;
            backTrack(resultList, queens, row+1, columns, diagonals1, diagonals2);
            columns[i] = 0;
            diagonals1.remove(row - i);
            diagonals2.remove(row + i);
            queens[row] = -1;
        }

    }

    private List<String> generate(int[] queens) {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int queen : queens) {
            for (int i = 0; i < queens.length; i++) {
                if (i == queen) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            list.add(builder.toString());
            builder.delete(0, builder.length());
        }
        return list;
    }


    public static void main(String[] args) {
        A0051NQueens algorithm = new A0051NQueens();
        List<List<String>> resultList = algorithm.solveNQueens(4);
        resultList.forEach(list -> {
            list.forEach(System.out::println);
            System.out.println();
        });
    }

}
