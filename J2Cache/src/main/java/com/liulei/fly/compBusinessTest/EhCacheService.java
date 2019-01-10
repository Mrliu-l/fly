package com.liulei.fly.compBusinessTest;

public interface EhCacheService {
    public Item getItem(String itemCode);

    public Item getItemWithEnCache(String itemCode);

    public void updateItem(String itemCode, Item item);

}
