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


}
