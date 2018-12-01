package com.zsx.pn.model;

import com.zsx.pn.anotationa.Token;

import javax.validation.constraints.NotNull;

public class UpdateUserModel {

    @NotNull(message = "请传入userId")
    private Integer userId;
    private String nickName;
    @Token
    @NotNull(message = "请传入token")
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
