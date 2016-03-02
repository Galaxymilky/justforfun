package com.logback.test;

import com.logback.test.a.TestA;
import com.logback.test.b.TestB;
import com.logback.test.c.TestC;
import com.logback.test.d.TestD;

public class Start {
    /**
     * Logback是由log4j创始人设计的又一个开源日志组件。
     * logback当前分成三个模块：logback-core,logback- classic和logback-access。
     * logback-core是其它两个模块的基础模块。
     * logback-classic是log4j的一个 改良版本。
     * 此外logback-classic完整实现SLF4J API使你可以很方便地更换成其它日志系统如log4j或JDK14 Logging。
     * logback-access访问模块与Servlet容器集成提供通过Http来访问日志的功能。
     * */
    public static void main(String[] args) {
        TestA a = new TestA();
        TestB b = new TestB();
        TestC c = new TestC();
        TestD d = new TestD();
    }

}