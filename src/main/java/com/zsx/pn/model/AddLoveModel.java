package com.zsx.pn.model;

import com.zsx.pn.anotationa.Token;

import javax.validation.constraints.NotNull;

public class AddLoveModel {
    @NotNull(message = "请传入userId")
    private Integer userId;
    @Token
    @NotNull(message = "请传入token")
    private String token;
    @NotNull(message = "请传入地点Id")
    private Integer placeId;

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

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "AddLoveModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", placeId=" + placeId +
                '}';
    }
}
