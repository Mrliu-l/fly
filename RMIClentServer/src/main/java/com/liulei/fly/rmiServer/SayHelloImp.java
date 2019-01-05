package com.liulei.fly.rmiServer;

import com.liulei.fly.ISayHello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Auther: fly
 * @Date: 2019/1/5
 * @Description:
 */
public class SayHelloImp extends UnicastRemoteObject implements ISayHello {
    protected SayHelloImp() throws RemoteException {
    }

    @Override
    public String sayHello(String message) throws RemoteException {
        System.out.println("server端收到消息:" + message);
        return "I'm server. hello...";
    }
}
