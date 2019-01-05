package com.liulei.fly;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.liulei.fly.kryo.KryoUtil;
import com.liulei.fly.model.PojoPersion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fly
 * @Date: 2019/1/5
 * @Description:序列化测试类
 */
public class TestSerialize {
    private static final int pojoNum = 1 * 10000;

    public static void main(String[] args) {
        List<PojoPersion> datas = getPojoPersionList();
        List<byte[]> bytesOfDatas = null;
        for(int i = 0; i < 5; i++)
            bytesOfDatas = serializeWithKryo(datas);
        for(int i = 0; i < 5; i++)
            deSerializeWithKryo(bytesOfDatas);
        for(int i = 0; i < 5; i++)
            bytesOfDatas = serializeWithProtobuf(datas);
        for(int i = 0; i < 5; i++)
            deSerializeWithProtobuf(bytesOfDatas);
    }

    public static void deSerializeWithProtobuf(List<byte[]> bytesOfDatas){
        Codec<PojoPersion> codec = ProtobufProxy.create(PojoPersion.class, false);
        long s0 = System.currentTimeMillis();
        for(int i = 0; i < pojoNum; i++){
            try {
                codec.decode(bytesOfDatas.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("protobuf反序列" + pojoNum + "个对象化耗时：" + (System.currentTimeMillis() - s0) + "ms;");
    }

    public static List<byte[]> serializeWithProtobuf(List<PojoPersion> datas){
        List<byte[]> bytesOfData = new ArrayList<>(datas.size());
        byte[] bytes = null;
        Codec<PojoPersion> codec = ProtobufProxy.create(PojoPersion.class, false);
        long s0 = System.currentTimeMillis();
        for(int i = 0; i < pojoNum; i++){
            try {
                bytes = codec.encode(datas.get(i));
                bytesOfData.add(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("protobuf序列化" + pojoNum + "个对象耗时：" + (System.currentTimeMillis() - s0) + "ms;大小为:" + bytes.length);
        return bytesOfData;
    }
    public static void deSerializeWithKryo(List<byte[]> bytesOfData){
        long s0 = System.currentTimeMillis();
        for(int i = 0; i < pojoNum; i++){
            KryoUtil.readFromByteArray(bytesOfData.get(i));
        }
        System.out.println("kryo反序列化" + pojoNum + "个对象耗时：" + (System.currentTimeMillis() - s0) + "ms;");
    }

    public static List<byte[]> serializeWithKryo(List<PojoPersion> datas){
        List<byte[]> bytesOfData = new ArrayList<>(datas.size());
        byte[] bytes = null;
        long s0 = System.currentTimeMillis();
        for(int i = 0; i < pojoNum; i++){
            bytes = KryoUtil.writeToByteArray(datas.get(i));
            bytesOfData.add(bytes);
        }
        System.out.println("kryo序列化" + pojoNum + "个对象耗时：" + (System.currentTimeMillis() - s0) + "ms;大小为:" + bytes.length);
        return bytesOfData;
    }

    public static List<PojoPersion> getPojoPersionList(){
        List<PojoPersion> pojoList = new ArrayList<>();
        for (int i = 0; i < pojoNum; i ++){
            PojoPersion pojoPersion = new PojoPersion();
            pojoPersion.setName("我的名字叫**" + i);
            pojoPersion.setHeight(i);
            pojoPersion.setWeight(i);
            pojoPersion.setSchool("我的学校是***，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript1("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript2("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript3("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript4("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript5("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript6("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript7("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript8("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript9("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript10("测试，我要多一点字符串，以便对象大一些" + i);
            pojoPersion.setDescript11("测试，我要多一点字符串，以便对象大一些" + i);
            pojoList.add(pojoPersion);
        }
        return pojoList;
    }
}
