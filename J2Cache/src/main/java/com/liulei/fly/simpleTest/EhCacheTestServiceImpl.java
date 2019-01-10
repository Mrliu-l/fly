package com.liulei.fly.simpleTest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/8 20:23
 * @Description: 描述:
 */
@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {
    @Override
    @Cacheable(value="cacheTest",key="#param")
    public TimeModel getTimestamp(String param) {
        TimeModel timeModel = new TimeModel();
        long timeStamp = System.currentTimeMillis();
        timeModel.setTime(String.valueOf(timeStamp));
        return timeModel;
    }
}
