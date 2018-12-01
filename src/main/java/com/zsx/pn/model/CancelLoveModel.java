package com.zsx.pn.model;

import com.zsx.pn.anotationa.Token;

import javax.validation.constraints.NotNull;

public class CancelLoveModel {
    @NotNull(message = "请传入userId")
    private Integer userId;
    @Token
    @NotNull(message = "请传入token")
    private String token;
    @NotNull(message = "请传入点赞Id")
    private Integer loveId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getLoveId() {
        return loveId;
    }

    public void setLoveId(Integer loveId) {
        this.loveId = loveId;
    }

    @Override
    public String toString() {
        return "CancelLoveModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", loveId=" + loveId +
                '}';
    }
}
