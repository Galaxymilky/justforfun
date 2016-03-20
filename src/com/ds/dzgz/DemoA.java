package com.ds.dzgz;

/**
 * Created by dynam on 3/19/2016.
 */
public class DemoA {
    public static void main(String[] args) {
        System.out.println(delNum("13243221", 5));
    }

    public static String delNum(String inputStr, int k) {
        int k_orig = k;
        int len = inputStr.length();

        int[] input = toIntegerArray(inputStr);

        while (k > 0) {
            int i = 0;
            for (; i < len - 1; ++i) {
                if (input[i] > input[i + 1]) {
                    break;
                }
            }

            for (; i < len - 1; ++i) {
                input[i] = input[i + 1];
            }

            --k;
            --len;

        }


        return inputStr.substring(0, input.length - k_orig);
    }

    public static int[] toIntegerArray(String str) {

        int[] result = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            result[i] = Integer.parseInt(str.charAt(i) + "");
        }
        return result;
    }



}
