package com.liulei.fly.rmiDemo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Auther: fly
 * @Date: 2019/1/5
 * @Description: 客户端要调用服务器端的接口
 *          因为这个接口需在在服务端与客户端共存（我没有新建两个工程，用两个包起的两个jvm表示clent与server），
 *          所以我将放在包外，以便公用
 */
public interface ISayHello extends Remote {
    public String sayHello(String message) throws RemoteException;
}
