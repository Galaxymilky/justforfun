package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by niu_ben on 2015/7/19.
 */
public class HelloClient {
    public static void main(String args[]){
        try {
            HelloRmi hello = null;
            hello = (HelloRmi)Naming.lookup("rmi://localhost:7002/hello");
            System.out.print(hello.helloRmi());
            System.out.print(hello.sendMess("你在想什么"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
