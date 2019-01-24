package com.telek.business.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCheckMap {

	String[] value() default {}; 

}
