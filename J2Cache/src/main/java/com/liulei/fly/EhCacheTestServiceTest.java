package com.liulei.fly;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/8 20:30
 * @Description: 描述:
 */
public class EhCacheTestServiceTest extends SpringTestCase {
    @Autowired
    private EhCacheTestService ehCacheTestService;

    @Test
    public void getTimestampTest() throws InterruptedException{
        System.out.println("第一次调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehCacheTestService.getTimestamp("param"));
    }
}
