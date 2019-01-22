package com.telek.business.annotation;

import com.telek.business.Type.CheckParamField;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckParam {

	CheckParamField[] value();

}
