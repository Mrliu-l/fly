package com.liulei.fly.rmiSourceDemo;

/**
 * @Auther: fly
 * @Date: 2019/1/6
 * @Description:
 */
public class SayHelloImpl implements ISayHello {
    @Override
    public String sayHello() {
        return "I'm server : hello";
    }
}
