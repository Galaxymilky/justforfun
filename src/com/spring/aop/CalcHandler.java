package com.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by dynam on 3/13/2016.
 */
public class CalcHandler implements InvocationHandler {

    public Object target;

    public CalcHandler(Object target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("~~~Code before the execute method~~~");
        Object obj = method.invoke(this.target, args);
        System.out.println("~~~Code after the execute method~~~");
        return obj;
    }

}
