package com.datastructure;

/**
 * @author GF
 * @since 2023/3/31
 */
public class BSDemo {

    /**
     * v1 - 不平衡
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1; //细节，无符号右移
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public int binarySearchJava(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1; //细节，无符号右移
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return - (left + 1);
    }


    /**
     * v2 - 不平衡
     */
    public int binarySearchV2(int[] nums, int target) {
       int left = 0, right = nums.length;
       while (left < right) {
           int mid = (left + right) >>> 1;
           if (nums[mid] < target) {
               left = mid + 1;
           } else if (nums[mid] > target) {
               right = mid;
           } else {
               return mid;
           }
       }
       return -1;
    }


    /**
     * v3 - 平衡
     * left指向最终结果，right是边界指针
     */
    public int binarySearchV3(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * @return >= target 最靠左的插入位置索引
     */
    public int binarySearchLeftMost(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1; //细节，无符号右移
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * @return <= target 最靠右的插入位置索引
     */
    public int binarySearchRightMost(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1; //细节，无符号右移
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left - 1;
    }



    public static void main(String[] args) {
        int[] nums = {
                1,2,3,4,6,6,6,6,8,9,15
        };
        final BSDemo bsDemo = new BSDemo();
//        int index = bsDemo.binarySearch(nums, 5);
//        int index2 = bsDemo.binarySearchV2(nums, 5);
//        int index3 = bsDemo.binarySearchV3(nums, 5);
//        int index4 = bsDemo.binarySearchJava(nums, 11);
//        int index5 = bsDemo.binarySearchLeftMost(nums, 5);
//        int index6 = bsDemo.binarySearchLeftMost(nums, 6);
//        int index7 = bsDemo.binarySearchRightMost(nums, 7);
//
//
//        System.out.println(index);
//        System.out.println(index2);
//        System.out.println(index3);
//        System.out.println(index4);
//        System.out.println(index5);
//        System.out.println(index6);
//        System.out.println(index7);

        int index = bsDemo.binarySearchLeftMost(nums, 5);
        int index2 = bsDemo.binarySearchRightMost(nums, 19);


////        System.out.println(index);
//        System.out.println(index2);
    }

}
