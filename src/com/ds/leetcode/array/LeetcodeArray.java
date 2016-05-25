package com.ds.leetcode.array;

/**
 * Created by dynam on 5/17/2016.
 */
public class LeetcodeArray {


    /**
     * Time Limit Exceeded
     */
    public static void rotate_1(int[] nums, int k) {
        if (nums.length != 0 && nums != null) {
            for (int i = 0; i < k + 1; i++) {
                int index = nums[0];
                for (int j = 0; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = index;
            }
        }


    }

    public static void rotate(int[] nums, int k) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < k; i++) {
            newArray[i] = nums[i + k + 1];
        }

        for (int i = k + 1; i < nums.length; i++) {
            newArray[i] = nums[i-k-1];
        }

        nums = newArray;


    }

    /**
     * 26. Remove Duplicates from Sorted Array
     * Given a [sorted] array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {

            } else {
                index++;
                nums[index] = nums[i + 1];
            }
        }
        return index + 1;
    }

    /**
     * 219. Contains Duplicate II
     * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
     * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        return false;
    }


    public static void main(String[] args) {
        System.out.println();
        LeetcodeArray arrayCode = new LeetcodeArray();


//        int[] nums = {1, 1, 1, 2, 2, 3, 5};
//        System.out.println(arrayCode.removeDuplicates(nums));
//        System.out.println(Arrays.toString(nums));

        int[] nums = {1, 2, 3};
        int k = 0;
        rotate(nums, k);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }



}
