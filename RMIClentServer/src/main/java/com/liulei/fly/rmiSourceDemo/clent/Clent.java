package com.liulei.fly.rmiSourceDemo.clent;

import com.liulei.fly.rmiSourceDemo.ISayHello;

import java.io.IOException;

/**
 * @Auther: fly
 * @Date: 2019/1/6
 * @Description: 调用的客户端
 */
public class Clent {
    public static void main(String[] args) throws IOException {
        ISayHello sayHello = new RmiStub();
        String message = sayHello.sayHello();
        System.out.println(message);
    }
}
