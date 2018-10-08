package com.zsx.pn.model;


public class PublishPlacesModel {
    private Integer userId;
    private String token;

    private Integer id;
    private Integer tagId;
    private String placeName;
    private String placePhone;
    private String placeDesc;
    private String placePhotos;
    private Double longitude;
    private Double latitude;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PublishPlacesModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", id=" + id +
                ", tagId=" + tagId +
                ", placeName='" + placeName + '\'' +
                ", placePhone='" + placePhone + '\'' +
                ", placeDesc='" + placeDesc + '\'' +
                ", placePhotos='" + placePhotos + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
