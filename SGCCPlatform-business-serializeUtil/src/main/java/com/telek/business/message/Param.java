package com.telek.business.message;

import com.telek.business.annotation.RequireParam;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/18 10:57
 * @Description: 描述:前后台交互参数对象
 */
public class Param {

    //登录单位
    private String loginCompcode;
    //查询单位
    private String compcode;
    //查询项目编码
    @RequireParam(maxLength = 100)
    private String itemCode;
    //查询项目名称
    @RequireParam(maxLength = 100)
    private String itemName;

    public String getLoginCompcode() {
        return loginCompcode;
    }

    public void setLoginCompcode(String loginCompcode) {
        this.loginCompcode = loginCompcode;
    }

    public String getCompcode() {
        return compcode;
    }

    public void setCompcode(String compcode) {
        this.compcode = compcode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Param{" +
                "loginCompcode='" + loginCompcode + '\'' +
                ", compcode='" + compcode + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
