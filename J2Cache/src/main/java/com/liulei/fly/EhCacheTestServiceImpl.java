package com.liulei.fly;

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
    public String getTimestamp(String param) {
        long timeStamp = System.currentTimeMillis();
        return String.valueOf(timeStamp);
    }
}
