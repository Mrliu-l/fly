package com.liulei.fly.rmiSourceDemo.server;

import com.liulei.fly.rmiSourceDemo.ISayHello;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: fly
 * @Date: 2019/1/6
 * @Description:rmi的Sekeleton，用于注册接口
 */
public class RmiSekeleton extends Thread{

    private ISayHello sayHello;

    public RmiSekeleton(ISayHello sayHello) {
        this.sayHello = sayHello;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket accept = serverSocket.accept();
            while (accept != null){
                ObjectInputStream read = new ObjectInputStream(accept.getInputStream());
                String url = (String) read.readObject();
                String interfaceName = url.split("/")[0];
                String methodName = url.split("/")[1];
                if(interfaceName.equals("ISayHello")){
                    switch (methodName){
                        case "sayHello":
                            String message = sayHello.sayHello();
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                            objectOutputStream.writeObject(message);
                            objectOutputStream.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
