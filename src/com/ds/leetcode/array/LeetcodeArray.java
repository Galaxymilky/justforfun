package com.ds.leetcode.array;

import com.ds.sort.MergingSort;

import java.util.Arrays;

/**
 * Created by dynam on 5/17/2016.
 */
public class LeetcodeArray {

    /**
     * 27.Remove Element
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * <p/>
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p/>
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * <p/>
     * Given input array nums = [3,2,2,3], val = 3
     * <p/>
     * Your function should return length = 2, with the first two elements of nums being 2.
     * {1} 3  return 0; {1} 1
     */
    public int removeElement(int[] nums, int val) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[j++] = nums[i];
            }
        }

        return j;
    }

    public int removeElement_laji(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length - index; i++) {
            if (val == nums[i]) {

                index++;

                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                if (nums[i] == val && i != nums.length - index) {
                    i--;
                }

            }
        }
        return nums.length - index;
    }


    /**
     * 189. Rotate Array
     * <p/>
     * Rotate an array of n elements to the right by k steps.
     * <p/>
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     * <p/>
     * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     * <p/>
     * Could you do it in-place with O(1) extra space?
     * <p/>
     * Related problem: Reverse Words in a String II
     */
    public static void rotate(int[] nums, int k) {
        if (k < 0 || nums.length == 0 || nums == null) {

        } else {
            if (k > nums.length) {
                k = k % nums.length;
            }
            int index = nums.length - k;
            int[] newArray = new int[nums.length];

            for (int i = 0; i < k; i++) {
                newArray[i] = nums[i + index];
            }

            for (int j = 0; j < index; j++) {
                newArray[j + k] = nums[j];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = newArray[i];
            }
        }

    }

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

    /**
     * 88. Merge Sorted Array
     * <p/>
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p/>
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, position = m + n - 1;
        while (j >= 0) {
            nums1[position--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
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
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        return false;
    }


    public static void main(String[] args) {
        System.out.println();
        LeetcodeArray arrayCode = new LeetcodeArray();


//        int[] nums = {1, 1, 1, 2, 2, 3, 5};
//        System.out.println(arrayCode.removeDuplicates(nums));
//        System.out.println(Arrays.toString(nums));


//        int[] nums = {1, 2, 3, 4, 5, 6};
//        int k = 11;
//        rotate(nums, k);
//        rotate_1(nums, k);


//        System.out.print(arrayCode.removeElement(nums, k));


//        int[] nums1 = new int[13];
//        int[] nums2 = {1, 2, 3, 4, 5, 6};
//        for (int i = 0; i < 6; i++) {
//            nums1[i] = i + 1;
//        }
//        arrayCode.merge(nums1, 6, nums2, 6);


//        System.out.println(Arrays.toString(nums1));
    }


}