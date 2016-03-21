package com.ds.stropt;

import com.ds.sort.TakeOutMIN;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by dynam on 3/19/2016.
 * 第一个只出现一次的字符
 * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
 */
public class DemoA {
    public static void main(String[] args) {
        String str = "aeadbccdebf";
        System.out.println(Test1(str));

        System.out.println(Test2(str));



    }

    private static String Test2(String str) {
        int[] intArray = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            intArray[i] = (int) str.charAt(i);
        }

        int index = TakeOutMIN.firstNoRepeatNum(intArray);

        return (char) intArray[index] + "";
    }

    private static String Test1(String str) {

        return TakeOutMIN.firstNoRepeatChar(str);
    }

    /**
     * 判断字符串是否是对称的
     */
    public static boolean isSymmetricB(String str) {
        int len = str.length();

        if (len == 0 || len == 1) {
            return false;
        }

        char[] chars = str.toCharArray();

        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) {
                return false;
            }
        }
        return true;

    }

    /**
     * 判断字符串是否是对称的
     */
    public static boolean isSymmetricA(String str) {

        int len = str.length();
        if (len == 0 || len == 1) {
            return false;
        }

        if (str.length() % 2 == 0) {

            if (str.substring(0, len / 2).equals(strReverse(str.substring(len / 2, len)))) {
                return true;
            }
        } else {

            if (str.substring(0, len / 2).equals(strReverse(str.substring(len / 2 + 1, len)))) {
                return true;
            }
        }

        return false;
    }

    /**
     * 逆序输出字符串
     */
    public static String strReverse(String str) {

        String result = "";
        for (int i = str.length() - 1; i > -1; i--) {
            result += str.charAt(i);
        }

        return result;
    }

}
