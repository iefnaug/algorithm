package com.a2025.str;

import java.util.HashMap;
import java.util.Map;

/*
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

提示：
n == nums.length
1 <= n <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
 */
public class A0169MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxCnt = nums.length / 2 + 1;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int cnt = map.get(num) + 1;
                if (cnt == maxCnt) {
                    return num;
                }
                map.put(num, cnt);
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }


    /**
     * 妙啊
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int cnt = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            cnt += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

}
