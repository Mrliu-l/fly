package com.telek.business.cache;

import com.google.common.collect.Maps;
import com.telek.business.annotation.ParamAttrRequire;
import io.protostuff.Schema;
import org.objenesis.instantiator.ObjectInstantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/21 14:38
 * @Description: 描述:
 */
public class CachePool {

    /**
     * 缓存对象及对象schema信息集合
     */
    public static Map<Class<?>, Schema<?>> CACHE_SCHEMA = Maps.newConcurrentMap();

    /**
     * 实体对象的Objenesis构造方法缓存信息集合
     */
    public static Map<Class<?>, ObjectInstantiator<?>> ObjectInstantiatorMap = new HashMap<>();

    /**
     * 实体对象的构造方法缓存信息集合
     */
    public static Map<Class<?>, Constructor> constructorMap = new HashMap<>();
    /**
     * 参数校验param对象上属性注解缓存信息集合
     */
    public static Map<Field, ParamAttrRequire> requireParamMap = new HashMap<>();
}
