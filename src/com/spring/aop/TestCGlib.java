package com.spring.aop;

/**
 * Created by dynam on 3/13/2016.
 */
public class TestCGlib {
    public static void main(String[] args) {
        CalcProxy proxy = new CalcProxy();
        CalcServiceImpl calcImpl = (CalcServiceImpl) proxy.getProxy(CalcServiceImpl.class);
        calcImpl.add(2, 3);
    }


}
