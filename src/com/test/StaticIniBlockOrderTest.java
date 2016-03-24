package com.test;

import java.util.LinkedList;

class Parent {
    static String name = "hello";
    //非静态代码块
    {
        System.out.println("parent block");
    }
    //静态代码块
    static {
        System.out.println("parent static block");
    }
    //构造方法
    public Parent() {
        System.out.println("parent constructor");
    }

}

class Child extends Parent {
    static String childName = "hello";

    {
        System.out.println("child block");
    }

    static {
        System.out.println("child static block");
    }

    public Child() {
        System.out.println("child constructor");
    }
}

public class StaticIniBlockOrderTest {

    public static void main(String[] args) {
        new Child();
        //System.out.println(Child.childName);
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.get(1);
    }
}