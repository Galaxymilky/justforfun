package com.dm;

/**
 * Created by niu_ben on 2016/3/24.
 *
 * Initialization on Demand Holder
 *
 * 可延迟加载、线程安全
 */
public class Singleton {
    private Singleton(){

    }

    private static class HolderClass{
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return HolderClass.instance;
    }

    public static void main(String[] args){
        Singleton s1, s2;
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }


}
