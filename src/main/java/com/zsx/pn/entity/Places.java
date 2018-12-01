package com.zsx.pn.entity;


import java.util.Date;

public class Places {
    private Integer id;
    private Integer tagId;
    private String placeName;
    private String placeDesc;
    private String placePhotos;
    private Double longitude;
    private Double latitude;
    private Integer creatorId;
    private Date createTime;

    private Integer loveCount;
    private Boolean love;
    private Integer collectCount;
    private Boolean collect;
    private Integer commentCount;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(Integer loveCount) {
        this.loveCount = loveCount;
    }

    public Boolean getLove() {
        return love;
    }

    public void setLove(Boolean love) {
        this.love = love;
    }

    public Boolean getCollect() {
        return collect;
    }

    public void setCollect(Boolean collect) {
        this.collect = collect;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
