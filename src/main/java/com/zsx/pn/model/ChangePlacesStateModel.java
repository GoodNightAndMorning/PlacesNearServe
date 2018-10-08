package com.zsx.pn.model;

public class ChangePlacesStateModel {
    private Integer userId;
    private String token;

    private Integer placeId;
    private Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ChangePlacesStateModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", placeId=" + placeId +
                ", state=" + state +
                '}';
    }
}
