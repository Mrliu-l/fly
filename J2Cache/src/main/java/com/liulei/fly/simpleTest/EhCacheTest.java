package com.liulei.fly.simpleTest;

import com.liulei.fly.SpringTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/8 20:30
 * @Description: 描述:
 */
public class EhCacheTest extends SpringTestCase {
    @Autowired
    private EhCacheTestService ehCacheTestServiceImpl;

    @Test
    public void getTimestampTest() throws InterruptedException{
        System.out.println("第一次调用：" + ehCacheTestServiceImpl.getTimestamp("param").getTime());
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestServiceImpl.getTimestamp("param").getTime());
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehCacheTestServiceImpl.getTimestamp("param").getTime());
    }
}
