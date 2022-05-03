package com.algorithm.search;

/*
 * @author GF
 * @since 2022/5/3
 */
public class BinarySearch {


    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {
                1,2,3,4,5,6,7,8,9
        };

        BinarySearch binarySearch = new BinarySearch();
        final int search = binarySearch.search(nums, 6);
        System.out.println(search);
    }

}
