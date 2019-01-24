package com.telek.business.annotation;

import java.lang.annotation.*;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/21 10:49
 * @Description: 描述: 传输参数校验类型
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamAttrRequire {

    //字段最大长度
    int maxLength() default 0;
}
