package com.spring.aop;

import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Proxy;

/**
 * Created by dynam on 3/13/2016.
 */
public class Test {
    public static void main(String[] args) {
//        testA();
        testC();

    }

    public static void testA() {

        long start = System.nanoTime();

        CalcService target = new CalcServiceImpl();
        CalcHandler handler = new CalcHandler(target);

        CalcService calcProxy = (CalcService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);

        System.out.println("CreateTime is " + (System.nanoTime() - start));

        start = System.nanoTime();
        calcProxy.add(2, 3);

        System.out.println("ExecuteTime is " + (System.nanoTime() - start));

    }


    public static void testC() throws AopConfigException {
        CalcService target = new CalcServiceImpl();

        CalcBeforeAdvice advice = new CalcBeforeAdvice();

        // 1 spring 提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        // 2 设置代理目标
        pf.setInterfaces(target.getClass().getInterfaces());// 指定对接口进行代理,将使用JdkDynamicAopProxy
        // 下面两行操作，有任意一行，都将使用Cglib2AopProxy
        pf.setOptimize(true);// 启用代理优化，将使用Cglib2AopProxy
        pf.setProxyTargetClass(true); // true表示对类进行代理，将使用Cglib2AopProxy

        pf.setTarget(target);
        // 3 为代理目标添加增强
        pf.addAdvice(advice);
        // 4 生成代理实例

        CalcService proxy = (CalcService) pf.getProxy();
        System.out.println(proxy.getClass().getName());
        proxy.add(2, 3);

    }

}
