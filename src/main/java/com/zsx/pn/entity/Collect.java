package com.zsx.pn.entity;

public class Collect {
    private Integer id;
    private Integer placeId;
    private Integer userId;
    private String createTime;

    private Places place;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Places getPlace() {
        return place;
    }

    public void setPlace(Places place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", placeId=" + placeId +
                ", userId=" + userId +
                ", createTime='" + createTime + '\'' +
                ", place=" + place +
                '}';
    }
}
