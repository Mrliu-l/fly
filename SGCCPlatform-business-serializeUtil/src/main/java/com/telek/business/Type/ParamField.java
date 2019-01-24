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
    public static Field loginCompCode = null;
    public static Field compCode = null;
    public static Field itemCode = null;
    public static Field itemName = null;
    public static Field year = null;
    public static Field volLevel = null;
    public static Field planYear = null;
    public static Field map = null;

    public static Field reportId = null;
    public static Field rows = null;
    public static Field planType = null;
    public static Field state = null;
    public static Field month = null;
    public static Field majorCode = null;
    public static Field prjKind = null;
    public static Field prjCode = null;
    public static Field prjName = null;
    public static Field wbsCode = null;
    public static Field itemType = null;

    static{
        Class clazz = Param.class;
        try {
            loginCompCode = clazz.getDeclaredField("loginCompCode");
            loginCompCode.setAccessible(true);
            compCode = clazz.getDeclaredField("compCode");
            compCode.setAccessible(true);
            itemCode = clazz.getDeclaredField("itemCode");
            itemCode.setAccessible(true);
            itemName = clazz.getDeclaredField("itemName");
            itemName.setAccessible(true);
            year = clazz.getDeclaredField("year");
            year.setAccessible(true);
            volLevel = clazz.getDeclaredField("volLevel");
            volLevel.setAccessible(true);
            planYear = clazz.getDeclaredField("planYear");
            planYear.setAccessible(true);
            map = clazz.getDeclaredField("map");
            map.setAccessible(true);
            
            reportId = clazz.getDeclaredField("reportId");
            reportId.setAccessible(true);
            rows = clazz.getDeclaredField("rows");
            rows.setAccessible(true);
            planType = clazz.getDeclaredField("planType");
            planType.setAccessible(true);
            state = clazz.getDeclaredField("state");
            state.setAccessible(true);
            month = clazz.getDeclaredField("month");
            month.setAccessible(true);
            majorCode = clazz.getDeclaredField("majorCode");
            majorCode.setAccessible(true);
            prjKind = clazz.getDeclaredField("prjKind");
            prjKind.setAccessible(true);
            prjCode = clazz.getDeclaredField("prjCode");
            prjCode.setAccessible(true);
            prjName = clazz.getDeclaredField("prjName");
            prjName.setAccessible(true);
            wbsCode = clazz.getDeclaredField("wbsCode");
            wbsCode.setAccessible(true);
            itemType = clazz.getDeclaredField("itemType");
            itemType.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
