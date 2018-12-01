package com.zsx.pn.model;

import com.zsx.pn.anotationa.Phone;

import javax.validation.constraints.*;


public class UserLoginModel {

    @Phone(values = "校验手机号码")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserLoginModel{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
