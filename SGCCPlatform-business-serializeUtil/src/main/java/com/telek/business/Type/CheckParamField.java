package com.telek.business.Type;

import com.telek.business.message.Param;

import java.lang.reflect.Field;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/21 10:59
 * @Description: 描述:校验field，用于注解中需要校验哪个字段，则使用哪个
 */
public enum CheckParamField {

    loginCompcode(ParamField.loginCompcode),
    compcode(ParamField.compcode),
    itemCode(ParamField.itemCode),
    itemName(ParamField.itemName);

    public Field field;
    CheckParamField(Field field) {
        this.field = field;
    }
}
