package com.ds.sort;

import java.util.*;


public class TakeOutMIN {

    public static void outMin(int[] array) {

        Arrays.sort(array);

        System.out.println("排序后数字为：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");

        boolean ok = false;

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            //System.out.print(a[i]+" ");
            if (ok) {
                break;
            }
            for (int j = i + 1; j < array.length; j++) {
                //System.out.print(array[j]+" ");
                if (array[i] == array[j]) {
                    break;
                } else {
                    if (array.length == j + 1) {
                        ok = true;
                        result = array[j];
                    } else if (i == 0) {
                        ok = true;
                        result = array[i];
                    } else {
                        if (array[j] != array[j + 1]) {
                            ok = true;
                            result = array[j];
                        }
                    }

                    break;
                }
            }
        }
        System.out.print("\n");
        System.out.println("最小不重复数为：" + result);

    }

    public static void outMinOrMax(String[] array, String sort) {

        if ("desc".equals(sort)) {
            Arrays.sort(array, Collections.reverseOrder());
        } else {
            Arrays.sort(array);
        }

        System.out.println("排序后数字为：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");

        boolean ok = false;

        String result = "";

        for (int i = 0; i < array.length; i++) {
            //System.out.print(a[i]+" ");
            if (ok) {
                break;
            }
            for (int j = i + 1; j < array.length; j++) {
                //System.out.print(array[j]+" ");
                if (array[i].equals(array[j])) {
                    break;
                } else {
                    if (array.length == j + 1) {
                        ok = true;
                        result = array[j];
                    } else if (i == 0) {
                        ok = true;
                        result = array[i];
                    } else {
                        if (!array[j].equals(array[j + 1])) {
                            ok = true;
                            result = array[j];
                        }
                    }

                    break;
                }
            }
        }
        System.out.print("\n");
        System.out.println("最小不重复数为：" + result);
    }

    public static int firstNoRepeatNum(int[] a) {
        Arrays.sort(a);

        if (a[0] != a[1]) {
            return 0;
        }
        for (int i = 1; i < a.length - 2; i++) {
            if (a[i] + a[i + 1] != 2 * a[i] && a[i + 1] + a[i + 2] != 2 * a[i + 1]) {
                return i + 1;
            }
        }

        return a.length - 1;
    }

    public static String firstNoRepeatChar(String str) {

        LinkedHashMap hashMap = new LinkedHashMap();

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            Object valObj = hashMap.get(key);
            int val = 0;
            if (valObj != null) {
                val = Integer.parseInt(valObj + "");
            }

            hashMap.remove(key);
            hashMap.put(key, val + 1);

        }

        for (Object obj : hashMap.keySet()) {
            if(Integer.parseInt(hashMap.get(obj)+"") == 1){
                return obj + "";
            }
        }
        return "";

    }


    /**
     * @param args
     */
    public static void main(String[] args) {

//        int[] array = {1, 5, 4, 2, 1, 2, 5, 3, 3};
//        outMin(array);
//        String[] array2 = {"1", "5", "4", "2", "2", "5", "3", "3", "7", "8", "8", "9"};
//        outMinOrMax(array2, "desc");
//
//        int index = firstNoRepeatNum(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(array[index]);

//        new MergingSort();

        new RadixSort();
    }

}
