package com.liulei.fly.compBusinessTest;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhCacheServiceImpl implements EhCacheService {

    @Override
    public Item getItem(String itemCode) {
        return CachePool.itemMap.get(itemCode);
    }

    @Cacheable(value = "compCacheTest", key = "#itemCode")
    @Override
    public Item getItemWithEnCache(String itemCode) {
        Item item =  CachePool.itemMap.get(itemCode);
        System.out.println("通过cachePool获取数据，key值为：" + itemCode + ",项目名称为：" + item.getItemName() + "；版本号为：" +item.getVersion());
        return item;
    }


    //假设此入口为redis保存更新接口
    @CacheEvict(value = "compCacheTest", key = "#itemCode")
    @Override
    public void updateItem(String itemCode, Item item){
        CachePool.itemMap.put(item.getItemCode(), item);
    }

}
