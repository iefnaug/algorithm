package com.algorithm.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * 1 <= nums.length <= 50
 * -10^6 <= nums[i] <= 10^6
 * nums 中的所有元素都是 唯一的
 *
 *
 * @author GF
 * @since 2023/11/4
 */
public class A0384ShuffleAnArray {

    private final int[] nums;
    private final int[] original;


    public A0384ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy( original, 0, nums, 0, original.length);
        return nums;
    }

    public int[] shuffle() {
        int[] result = new int[nums.length];
        Random random = new Random();
        int len = result.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < len; i++) {
            int idx = random.nextInt(list.size());
            result[i] = list.remove(idx);
        }
        System.arraycopy(result, 0, nums, 0, len);
        return nums;
    }

    /**
     * Fisher-Yates 洗牌算法
     */
    public int[] shuffle2() {
        Random random = new Random();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = i + random.nextInt(len - i);
            //replace
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        A0384ShuffleAnArray algorithm = new A0384ShuffleAnArray(new int[]{
                1,2,3,4,5,6,7,8,9
        });
//        int[] shuffle = algorithm.shuffle();
//        Arrays.stream(shuffle).forEach(ele -> System.out.print(ele + ", "));
//        System.out.println();
//        shuffle = algorithm.shuffle();
//        Arrays.stream(shuffle).forEach(ele -> System.out.print(ele + ", "));
//        System.out.println();
//        shuffle = algorithm.shuffle();
//        Arrays.stream(shuffle).forEach(ele -> System.out.print(ele + ", "));
//        System.out.println();


        int[] shuffle = algorithm.shuffle2();
        Arrays.stream(shuffle).forEach(ele -> System.out.print(ele + ", "));
        System.out.println();
        shuffle = algorithm.shuffle2();
        Arrays.stream(shuffle).forEach(ele -> System.out.print(ele + ", "));
        System.out.println();
        shuffle = algorithm.shuffle2();
        Arrays.stream(shuffle).forEach(ele -> System.out.print(ele + ", "));
        System.out.println();
        shuffle = algorithm.shuffle2();
        Arrays.stream(shuffle).forEach(ele -> System.out.print(ele + ", "));
        System.out.println();


    }


}
