package com.sgcc;

import com.telek.business.message.Param;
import com.telek.business.protoUtil.SerializeUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/21 17:00
 * @Description: 描述:
 */
public class Test {

    public static void main(String[] args) throws IOException, NoSuchFieldException {
        Class clazz = Param.class;
        Field loginCompcode = clazz.getDeclaredField("loginCompcode");
        Map<String,String> paras = new HashMap<String,String>();
        SerializeUtil.initProtoParam(false);
        Param param = new Param();
        param.setCompCode("41311016120100001");
        param.setCompCode("41311016120100001");
        param.setItemCode("asdf");
        byte[] serialize = SerializeUtil.serialize(param);
        paras.put("param", serialize.toString());
        String url = "/sanlv/getContructionItem";
    }
}
