package com.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by dynam on 3/13/2016.
 */
public class CalcBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object obj) throws Throwable {
        System.out.println("~~~Code before the execute method~~~");
    }
}
