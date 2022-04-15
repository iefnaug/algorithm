package com.algorithm.sort.classic;

/**
 * 冒泡
 */
public class BubbleSort {

    /**
     * 冒泡排序：每一轮交换，将最大的元素放到最后
     * 1、如果一轮排序中，没有再交换元素，则肯定已经完成排序
     * 2、每一轮最后一次交换的位置，一定是下一轮的排序范围的最大索引
     */
    public void bubbleSort(int[] nums) {
        int sortRange = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean sorted = true;
            int lastExchangeIndex = 0;
            for (int j = 0; j < sortRange; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    sorted = false;
                    lastExchangeIndex = j;
                }
            }
            if (sorted) {
                break;
            }
            sortRange = lastExchangeIndex;
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = new int[] {
           1,3,5,7,9,2,4,6,8
        };
        bubbleSort.bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
