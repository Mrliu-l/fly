package com.telek.business.annotation;

import com.telek.business.Type.CheckParamField;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/21 10:49
 * @Description: 描述: 传输参数校验类型
 */
public @interface RequireParam {

    //字段最大长度
    int maxLength() default 0;
}
