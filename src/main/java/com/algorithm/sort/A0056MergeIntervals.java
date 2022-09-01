package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * <a href="https://leetcode.cn/problems/merge-intervals">algorithm</a>
 */
public class A0056MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> mergedList = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (mergedList.size() == 0 || mergedList.get(mergedList.size() - 1)[1] < left) {
                mergedList.add(new int[]{left, right});
            } else {
                int rightVal = mergedList.get(mergedList.size() - 1)[1];
                mergedList.get(mergedList.size() - 1)[1] = Math.max(rightVal, right);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][0]);
    }

    public static void main(String[] args) {
        int[][] source = new int[][] {
                {1,3},{2,6},{8,10},{15,18}
        };
        A0056MergeIntervals algorithm = new A0056MergeIntervals();
        int[][] merge = algorithm.merge(source);
        System.out.println();
    }

}
