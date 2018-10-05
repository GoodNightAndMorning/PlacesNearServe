package com.zsx.pn.model;

public class UpdateUserModel {
    private Integer userId;
    private String nickName;
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UpdateUserModel{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
