package com.liulei.fly.rmiServer;

import com.liulei.fly.ISayHello;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Auther: fly
 * @Date: 2019/1/5
 * @Description:
 */
public class RmiServer {
    public static void main(String[] args) {
        try {
            ISayHello sayHello = new SayHelloImp();
            //服务端注册并监听端口
            LocateRegistry.createRegistry(8888);
            //服务器监听api
            Naming.bind("rmi://127.0.0.1:8888/sayHello", sayHello);
            System.out.println("server start...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
