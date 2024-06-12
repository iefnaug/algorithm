package com.a2024.slidingwindow;

import java.util.Arrays;
import java.util.TreeMap;

/**
 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回 滑动窗口中的最大值 。



 示例 1：

 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 输出：[3,3,5,5,6,7]
 解释：
 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 示例 2：

 输入：nums = [1], k = 1
 输出：[1]


 提示：

 1 <= nums.length <= 10^5
 -10^4 <= nums[i] <= 10^4
 1 <= k <= nums.length
 */
public class A0239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = k - 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < index; i++) {
            if (treeMap.containsKey(nums[i])) {
                treeMap.put(nums[i], treeMap.get(nums[i]) + 1);
            } else {
                treeMap.put(nums[i], 1);
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (treeMap.containsKey(nums[i])) {
                treeMap.put(nums[i], treeMap.get(nums[i]) + 1);
            } else {
                treeMap.put(nums[i], 1);
            }
            Integer target = treeMap.lastKey();
            result[i - index] = target;
            if (treeMap.get(nums[i-index]) == 1) {
                treeMap.remove(nums[i-index]);
            } else {
                treeMap.put(nums[i-index], treeMap.get(nums[i-index]) - 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        A0239 algorithm = new A0239();
        int[] result = algorithm.maxSlidingWindow(nums, k);
        Arrays.stream(result).forEach(System.out::println);
    }

}
