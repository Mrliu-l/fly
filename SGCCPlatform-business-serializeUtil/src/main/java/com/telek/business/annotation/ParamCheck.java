package com.telek.business.annotation;

import com.telek.business.Type.ParamCheckField;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCheck {

	ParamCheckField[] value();

}
