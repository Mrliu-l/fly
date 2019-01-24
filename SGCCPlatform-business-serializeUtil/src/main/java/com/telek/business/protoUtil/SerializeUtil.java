package com.telek.business.protoUtil;

import com.telek.business.annotation.ParamAttrRequire;
import com.telek.business.cache.CachePool;
import com.telek.business.message.Param;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/15 10:16
 * @Description: 描述:
 */
public class SerializeUtil {

    private static Log logger = LogFactory.getLog(SerializeUtil.class);

    /**
     * 需要使用包装类进行序列化/反序列化的class集合
     */
    private static final Set<Class<?>> WRAPPER_SET = new HashSet<>();

    /**
     * 序列化/反序列化包装类 Class 对象
     */
    private static final Class<SerializeDeserializeWrapper> WRAPPER_CLASS = SerializeDeserializeWrapper.class;

    /**
     * 序列化/反序列化包装类 Schema 对象
     */
    private static final Schema<SerializeDeserializeWrapper> WRAPPER_SCHEMA = RuntimeSchema.createFrom(WRAPPER_CLASS);

    /**
     * 预定义一些Protostuff无法直接序列化/反序列化的对象
     */
    static {
        WRAPPER_SET.add(List.class);
        WRAPPER_SET.add(ArrayList.class);
        WRAPPER_SET.add(CopyOnWriteArrayList.class);
        WRAPPER_SET.add(LinkedList.class);
        WRAPPER_SET.add(Stack.class);
        WRAPPER_SET.add(Vector.class);

        WRAPPER_SET.add(Map.class);
        WRAPPER_SET.add(HashMap.class);
        WRAPPER_SET.add(TreeMap.class);
        WRAPPER_SET.add(Hashtable.class);
        WRAPPER_SET.add(SortedMap.class);
        WRAPPER_SET.add(Map.class);

        WRAPPER_SET.add(Object.class);
    }

    /**
     * 注册需要使用包装类进行序列化/反序列化的 Class 对象
     *
     * @param clazz 需要包装的类型 Class 对象
     */
    public static void registerWrapperClass(Class clazz) {
        WRAPPER_SET.add(clazz);
    }

    /**
     * 获取序列化对象类型的schema
     *
     * @param cls 序列化对象的class
     * @param <T> 序列化对象的类型
     * @return 序列化对象类型的schema
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static <T> Schema<T> getSchema(Class<T> cls) {
        Schema<T> schema = (Schema<T>) CachePool.CACHE_SCHEMA.get(cls);
        if (schema == null) {
            schema = RuntimeSchema.createFrom(cls);
            CachePool.CACHE_SCHEMA.put(cls, schema);
        }
        return schema;
    }

    /**
     * 序列化对象
     *
     * @param obj 需要序列化的对象
     * @param <T> 序列化对象的类型
     * @return 序列化后的二进制数组
     */
    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T obj) {
        Class<T> clazz = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Object serializeObject = obj;
            Schema schema = WRAPPER_SCHEMA;
            if (!WRAPPER_SET.contains(clazz)) {
                schema = getSchema(clazz);
            } else {
                serializeObject = SerializeDeserializeWrapper.builder(obj);
            }
            return ProtostuffIOUtil.toByteArray(serializeObject, schema, buffer);
        } catch (Exception e) {
            logger.error("序列化对象异常 [" + obj + "]", e);
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }

    /**
     * 反序列化对象
     *
     * @param data  需要反序列化的二进制数组
     * @param clazz 反序列化后的对象class
     * @param <T>   反序列化后的对象类型
     * @return 反序列化后的对象集合
     */
    public static <T> T deserialize(byte[] data, Class<T> clazz) {
        try {
            if (!WRAPPER_SET.contains(clazz)) {
                T message = null;
                Constructor constructor = CachePool.constructorMap.get(clazz);
                if(constructor != null){
                    message = (T) constructor.newInstance(null);
                }else{
                    message = (T) CachePool.ObjectInstantiatorMap.get(clazz).newInstance();
                }
                Schema<T> schema = getSchema(clazz);
                ProtostuffIOUtil.mergeFrom(data, message, schema);
                return message;
            } else {
                SerializeDeserializeWrapper<T> wrapper = new SerializeDeserializeWrapper<>();
                ProtostuffIOUtil.mergeFrom(data, wrapper, WRAPPER_SCHEMA);
                return wrapper.getData();
            }
        } catch (Exception e) {
            logger.error("反序列化对象异常 [" + clazz.getName() + "]", e);
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * @author liu_l
     * @created 2019/1/16 17:24
     * @email: liu_lei_programmer@163.com
     * TODO 简要描述方法的作用：
            预编译序列化所需要的对象无惨构造方法与schema
     * TODO(这里描述这个方法的执行流程 – 可选)
            1、加载无惨构造方法
            2、加载schema
            3、加载前台传参注解信息
     */
    public static void initProtoParam(boolean isBackServer){
        //搜索com.telek.business.cache.model包下所有类型
        Set<Class<?>> classes = new HashSet<>();
        if(isBackServer){
            classes = ScanClassUtil.getClasses("com.telek.business.cache.model");
        }
        classes.add(Param.class);
        for (Class<?> clazz : classes) {
            if(Modifier.isAbstract(clazz.getModifiers())){
                continue;
            }
            //1、加载无惨构造方法
            Objenesis objenesis = new ObjenesisStd();
            try {
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                CachePool.constructorMap.put(clazz, constructor);
            } catch (NoSuchMethodException e) {
                ObjectInstantiator<?> objectInstantiator = objenesis.getInstantiatorOf(clazz);
                CachePool.ObjectInstantiatorMap.put(clazz, objectInstantiator);
                System.out.println(clazz + "没有构造方法");
            }
            //2、加载schema
            CachePool.CACHE_SCHEMA.put(clazz, RuntimeSchema.getSchema(clazz));
            //3、加载前台传参注解信息
            Field[] fields = Param.class.getDeclaredFields();
            for(Field field : fields){
                ParamAttrRequire paramAttrRequire = field.getAnnotation(ParamAttrRequire.class);
                CachePool.requireParamMap.put(field, paramAttrRequire);
            }
        }
    }

}
