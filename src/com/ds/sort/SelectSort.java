package com.ds.sort;

import java.util.Arrays;

/**
 * Created by niu_ben on 2016/3/7.
 */
public class SelectSort {

    int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    public SelectSort(){
        selectSort(a);
    }

    public static void selectSort(int[] a){
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

            System.out.println(Arrays.toString(a));
        }
    }
}
