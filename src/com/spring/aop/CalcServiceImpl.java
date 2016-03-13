package com.spring.aop;

/**
 * Created by dynam on 3/13/2016.
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public void add(int x, int y) {
        System.out.println("Result is " + (x + y));
    }
}
