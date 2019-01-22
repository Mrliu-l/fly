package com.telek.business.Type;

import com.telek.business.message.Param;

import java.lang.reflect.Field;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/21 11:14
 * @Description: 描述: 参数对象中的field，用于提供给CheckParamField
 */
public class ParamField {
    public static Field loginCompcode = null;
    public static Field compcode = null;
    public static Field itemCode = null;
    public static Field itemName = null;

    static{
        Class clazz = Param.class;
        try {
            loginCompcode = clazz.getField("loginCompcode");
            loginCompcode.setAccessible(true);
            compcode = clazz.getField("compcode");
            compcode.setAccessible(true);
            itemCode = clazz.getField("itemCode");
            itemCode.setAccessible(true);
            itemName = clazz.getField("itemName");
            itemName.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
