package com.offer;

/**
 * 只出现一次的数字
 * @since 2024/8/14
 */
public class Offer004 {

    /**
     * 数组中只出现一次的数字，其他的均出现3次
     */
    public int onlyOneTime(int[] nums) {
        int[] result = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                result[i] += num >>> i & 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] % 3 == 1) {
                sum += 1 << i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {
                2,2,2,3,3,3,4,4,4,-6
        };
        Offer004 algorithm = new Offer004();
        int i = algorithm.onlyOneTime(nums);
        System.out.println(i);
    }
}
