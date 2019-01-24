package com.liulei.fly.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/24 9:44
 * @Description: 描述:
 */
public class CuratorOperatorDemo {


    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorClientUtils.getInstance();
        try {
            String path = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                    .forPath("test/test1/test1-1", "123".getBytes());
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("success");
    }
}
