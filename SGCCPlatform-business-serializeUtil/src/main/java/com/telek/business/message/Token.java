package com.telek.business.message;

import com.telek.business.jwtUtil.CheckJwtResultType;

/**
 * @author liu_l
 * @email: liu_lei_programmer@163.com
 * @time 2019/1/24 15:26
 * @Description: 描述:
 */
public class Token {
    private String cookie;
    private String userName;
    private String loginCompCode;
    private String compCode;
    private CheckJwtResultType checkJwtResultType;

    public CheckJwtResultType getCheckJwtResultType() {
        return checkJwtResultType;
    }

    public void setCheckJwtResultType(CheckJwtResultType checkJwtResultType) {
        this.checkJwtResultType = checkJwtResultType;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginCompCode() {
        return loginCompCode;
    }

    public void setLoginCompCode(String loginCompCode) {
        this.loginCompCode = loginCompCode;
    }

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }
}
