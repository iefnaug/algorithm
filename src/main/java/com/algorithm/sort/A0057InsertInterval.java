package com.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 *给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 
 *
 * 示例1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *
 * <a href="ttps://leetcode.cn/problems/insert-interval>algorithm</a>
 */
public class A0057InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        List<int[]> resultList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < left) {
                //无交集
                resultList.add(interval);
            } else if (interval[0] > right) {
                //无交集
                if (!placed) {
                    resultList.add(new int[] {left, right});
                    placed = true;
                }
                resultList.add(interval);
            } else {
                //有交集
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if (!placed) {
            resultList.add(new int[] {left, right});
        }
        return resultList.toArray(new int[resultList.size()][0]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1,2},{3,5},{6,7},{8,10},{12,16}
        };
        int[] newInterval = {4, 8};
        A0057InsertInterval algorithm = new A0057InsertInterval();
        int[][] result = algorithm.insert(intervals, newInterval);
        System.out.println(result);
    }
}
