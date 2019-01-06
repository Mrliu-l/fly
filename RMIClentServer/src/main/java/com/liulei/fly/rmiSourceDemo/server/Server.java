package com.liulei.fly.rmiSourceDemo.server;

import com.liulei.fly.rmiSourceDemo.ISayHello;
import com.liulei.fly.rmiSourceDemo.SayHelloImpl;

/**
 * @Auther: fly
 * @Date: 2019/1/6
 * @Description:服务端
 */
public class Server {
    public static void main(String[] args) {
        ISayHello sayHello = new SayHelloImpl();
        RmiSekeleton rmiSekeleton = new RmiSekeleton(sayHello);
        rmiSekeleton.start();
        System.out.println("server start...");
    }
}
