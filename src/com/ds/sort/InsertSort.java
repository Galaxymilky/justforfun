package com.ds.sort;

import java.util.Arrays;

/**
 * Created by dynam on 3/7/2016.
 */
public class InsertSort {

    public InsertSort() {
        int a[] = {49, 11, 123, 12, 1, 5, 19};

        int temp = 0;

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
                System.out.println(Arrays.toString(a));
            }
            a[j + 1] = temp;

            //System.out.println(Arrays.toString(a));
        }
    }
}