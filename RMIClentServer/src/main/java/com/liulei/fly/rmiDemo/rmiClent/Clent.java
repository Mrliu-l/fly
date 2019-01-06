package com.liulei.fly.rmiDemo.rmiClent;

import com.liulei.fly.rmiDemo.ISayHello;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Auther: fly
 * @Date: 2019/1/5
 * @Description:
 */
public class Clent {
    public static void main(String[] args) {
        try {
            //返回从服务端获取该接口的引用
            ISayHello sayHello = (ISayHello) Naming.lookup("rmi://127.0.0.1:8888/sayHello");
            //利用引用调用方法
            String reseiveMessage = sayHello.sayHello("hello, I'm clent...");
            System.out.println("clent端收到回复:" + reseiveMessage);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
