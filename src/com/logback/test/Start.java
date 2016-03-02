package com.logback.test;

import com.logback.test.a.TestA;
import com.logback.test.b.TestB;
import com.logback.test.c.TestC;
import com.logback.test.d.TestD;

public class Start {
    /**
     * Logback����log4j��ʼ����Ƶ���һ����Դ��־�����
     * logback��ǰ�ֳ�����ģ�飺logback-core,logback- classic��logback-access��
     * logback-core����������ģ��Ļ���ģ�顣
     * logback-classic��log4j��һ�� �����汾��
     * ����logback-classic����ʵ��SLF4J APIʹ����Ժܷ���ظ�����������־ϵͳ��log4j��JDK14 Logging��
     * logback-access����ģ����Servlet���������ṩͨ��Http��������־�Ĺ��ܡ�
     * */
    public static void main(String[] args) {
        TestA a = new TestA();
        TestB b = new TestB();
        TestC c = new TestC();
        TestD d = new TestD();
    }

}