package com.ds.sort;

import java.util.Arrays;

/**
 * Created by dynam on 3/7/2016.
 */
public class ShellSort {
    public ShellSort() {
        int a[] = {1, 54, 6, 3, 78, 34, 12, 45, 56, 109};

        double d1 = a.length;

        int temp = 0;

        while (true) {
            d1 = Math.ceil(d1 / 2);

            int d = (int) d1;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i++) {
                    int j = i - d;
                    temp = a[i];
                    for (; j >= 0 && temp < a[j]; j -= d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }

            if(d ==1 ){
                break;
            }

            System.out.println(Arrays.toString(a));
        }
    }
}
