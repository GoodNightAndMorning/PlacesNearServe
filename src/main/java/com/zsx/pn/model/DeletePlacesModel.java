package com.zsx.pn.model;

public class DeletePlacesModel {
    private Integer userId;
    private String token;

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
        return "DeletePlacesModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", placeId=" + placeId +
                '}';
    }
}
