package com.liulei.fly.compBusinessTest;

import com.liulei.fly.SpringTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class EhCacheTestComp extends SpringTestCase {

    @Autowired
    private EhCacheService ehCacheServiceImpl;

    @Test
    public void test() throws InterruptedException {
        this.initCachePool();
        String key = "12345aaa";
        //第一次获取item，目的是将jvm中数据放入EhCache中
        Item item = ehCacheServiceImpl.getItemWithEnCache(key);
        TimeUnit.SECONDS.sleep(5);
        //测试第二次获取是否从Ehcache中获取数据
        item = ehCacheServiceImpl.getItem(key);
        System.out.println("第二次获取数据,编码为" + item.getItemCode() + "，版本号为：" + item.getVersion());
        //修改数据，看Ehcache中数据是否会失效
        item.setItemName("项目名称我修改了");
        ehCacheServiceImpl.updateItem(key,item);
        item = ehCacheServiceImpl.getItem(key);

    }

    public void initCachePool(){
        Item item = new Item("项目1", "12345aaa");
        CachePool.itemMap.put(item.getItemCode(), item);
    }
}
