package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by niu_ben on 2015/7/19.
 */
public class HelloRmiImpl extends UnicastRemoteObject implements HelloRmi {
    public HelloRmiImpl() throws RemoteException{

    }

    @Override
    public String helloRmi() throws RemoteException {
        return "Hello!";
    }

    @Override
    public String sendMess(String str) throws RemoteException {
        return "Here is Mess: " + str;
    }
}
