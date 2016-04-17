package com.ds.sort;

import java.util.*;

/**
 * Created by niu_ben on 2016/3/29.
 */
public class SortUtils {
    public static void main(String[] args) {

        int a[] = {49, 11, 123, 12, 1, 5, 19};
        insertSort(a);
        System.out.println(Arrays.toString(a));

        int[] a2 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        QuickSorter.quickSort(a2);
        System.out.println(Arrays.toString(a2));

        int a3[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        bubbleSort(a3);
        System.out.println(Arrays.toString(a3));

        int a4[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        HeapSort.heapSort(a4);
        System.out.println(Arrays.toString(a4));

        int a5[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        selectSort(a5);
        System.out.println(Arrays.toString(a5));


    }

    public static void insertSort(int[] array) {
        int insertNode = 0;
        int i, j;
        for (i = 0; i < array.length; i++) {
            insertNode = array[i];
            j = i - 1;

            while (j >= 0 && insertNode < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNode;
        }
    }

    public static class QuickSorter {

        private int[] array;

        public QuickSorter(int[] array) {
            this.array = array;
        }

        public static void quickSort(int[] array) {
            _quick(array, 0, array.length - 1);
        }

        public static void _quick(int[] array, int low, int high) {
            if (low < high) {
                int middle = getMiddle(array, low, high);
                _quick(array, low, middle - 1);
                _quick(array, middle + 1, high);
            }
        }

        private static int getMiddle(int[] array, int low, int high) {
            int tmp = array[low];
            while (low < high) {
                while (low < high && array[high] >= tmp) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] <= tmp) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = tmp;
            return low;
        }

    }

    public static void bubbleSort(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    static class HeapSort {
        public HeapSort() {

        }

        public static void heapSort(int[] a) {

        }


    }

    public static class MergingSorter {
        public MergingSorter() {

        }

        public static void mergingSort(int[] a) {

        }


    }

    public static void selectSort(int[] a) {

        int position = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i + 1;
            position = i;
            int temp = a[i];
            for (; j < a.length; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }
    }


}