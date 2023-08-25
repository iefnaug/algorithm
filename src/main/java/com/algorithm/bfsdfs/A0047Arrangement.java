package com.algorithm.bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @author GF
 * @since 2023/8/25
 */
public class A0047Arrangement {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrack(ans, list, nums, visited, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] visited, int pos) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(ans, list, nums, visited, pos + 1);
            list.remove(pos);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,3,4};
        int[] nums = {1,2,3,3};
        A0047Arrangement algorithm = new A0047Arrangement();
        List<List<Integer>> ans = algorithm.permuteUnique(nums);
        for (List<Integer> list : ans) {
            list.forEach(ele -> System.out.print(ele + ","));
            System.out.println();
        }
    }

}
