package com.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by niu_ben on 2015/7/19.
 */
public class HelloServer {

    public static void main(String[] args){
        try{
            HelloRmi hello = new HelloRmiImpl();

            LocateRegistry.createRegistry(7002);

            Naming.bind("rmi://localhost:7002/hello", hello);

        }catch(RemoteException re){
            System.out.print("Unable to create the RemoteObject");
            re.printStackTrace();
        }catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
