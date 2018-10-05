package com.zsx.pn.model;

public class UserLoginModel {
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
