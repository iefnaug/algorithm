package com.algorithm.array;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * @author GF
 * @since 2023/6/4
 */
public class A0136SingleNumber {


    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,1,2,2,3,3,4,5,5,6,6,7,7
        };
        A0136SingleNumber algorithm = new A0136SingleNumber();
        int result = algorithm.singleNumber(nums);
        System.out.println(result);

    }

}
