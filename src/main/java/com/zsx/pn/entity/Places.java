package com.zsx.pn.entity;

import java.util.Date;

public class Places {
    private Integer id;
    private Integer tagId;
    private String placeName;
    private String placePhone;
    private String placeDesc;
    private String placePhotos;
    private Double longitude;
    private Double latitude;
    private Integer creatorId;
    private Date createTime;
    private Integer state;

    private Tags tags;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlacePhone() {
        return placePhone;
    }

    public void setPlacePhone(String placePhone) {
        this.placePhone = placePhone;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
    }

    public String getPlacePhotos() {
        return placePhotos;
    }

    public void setPlacePhotos(String placePhotos) {
        this.placePhotos = placePhotos;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Places{" +
                "id=" + id +
                ", tagId=" + tagId +
                ", placeName='" + placeName + '\'' +
                ", placePhone='" + placePhone + '\'' +
                ", placeDesc='" + placeDesc + '\'' +
                ", placePhotos='" + placePhotos + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", state=" + state +
                ", tags=" + tags +
                ", user=" + user +
                '}';
    }
}
