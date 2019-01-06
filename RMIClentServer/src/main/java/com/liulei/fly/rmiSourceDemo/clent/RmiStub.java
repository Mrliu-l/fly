package com.liulei.fly.rmiSourceDemo.clent;

import com.liulei.fly.rmiSourceDemo.ISayHello;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Auther: fly
 * @Date: 2019/1/6
 * @Description:rmi利用stub反射实现调用服务端注册的方法
 */
public class RmiStub implements ISayHello {

    private Socket socket;

    public RmiStub() throws IOException {
        this.socket = new Socket("127.0.0.1", 8888);
    }

    @Override
    public String sayHello() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            String url = "ISayHello/sayHello";
            objectOutputStream.writeObject(url);
            objectOutputStream.flush();

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String message = (String) objectInputStream.readObject();
            return message;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
