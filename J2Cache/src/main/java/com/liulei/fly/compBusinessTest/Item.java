package com.liulei.fly.compBusinessTest;

import net.sf.ehcache.util.TimeUtil;

import java.util.concurrent.TimeUnit;

public class Item {
    private String itemName;

    private String itemCode;

    private int version = 0;

    public Item(String itemName, String itemCode) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                version += version;
            }
        }).run();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
