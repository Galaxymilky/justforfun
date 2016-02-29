package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by niu_ben on 2015/7/18.
 * define a remote interface,must extends Remote
 */
public interface HelloRmi extends Remote {
    /**
     * @return str "Hello Rmi!"
     * @throws java.rmi.RemoteException
     * */
    public String helloRmi() throws RemoteException;

    public String sendMess(String str) throws RemoteException;

}
