package com.ds.microsoft;

import java.util.Arrays;

/**
 * Created by dynam on 3/6/2016.
 * 查找最小的K个元素
 * 输入n 个整数，输出其中最小的k 个。
 * <p/>
 * This is a very traditional question...
 * O(nlogn): cat I_FILE | sort -n | head -n K
 * O(kn): do insertion sort until k elements are retrieved.
 * O(n+klogn): Take O(n) time to bottom-up build a min-heap. Then sift-down k-1 times.
 * So traditional that I don’t want to write the codes...
 * Only gives the siftup and siftdown function.
 */
public class Demo5 {

    public static int[] InsertSort(int[] arr) {
        int i, j;
        int insertNote;//要插入的数据


        //从数组的第二个元素开始循环将数组中的元素插入
        for (i = 1; i < arr.length; i++) {
            //设置数组中的第2个元素为第一次循环要播讲的数据
            insertNote = arr[i];
            j = i - 1;
            while (j >= 0 && insertNote < arr[j]) {
                //如果要播讲的元素小于第j个元素,就将第j个元素向后移动
                arr[j + 1] = arr[j];
                j--;
            }
            //直到要插入的元素不小于第j个元素,将insertNote插入到数组中
            arr[j + 1] = insertNote;
        }
        //打印排序后的数组
        System.out.println(Arrays.toString(arr));
        return arr;

    }

    public static void main(String[] args) {
        int[] arr= new int[]{800,9,3,6,12,54,35,411,3,245,1,0,4};
        InsertSort(arr);
    }

}
