package com.liulei.fly.compBusinessTest;

import org.springframework.cache.annotation.CachePut;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachePool {

    //假设次jvm缓存为redis缓存
    public static Map<String, Item> itemMap = new ConcurrentHashMap<>();

}
