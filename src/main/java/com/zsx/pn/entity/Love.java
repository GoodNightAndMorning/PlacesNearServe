package com.zsx.pn.entity;

public class Love {
    private Integer id;
    private Integer placeId;
    private Integer creatorId;
    private String createTime;

    private Places place;
    private User creator;

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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Love{" +
                "id=" + id +
                ", placeId=" + placeId +
                ", creatorId=" + creatorId +
                ", createTime='" + createTime + '\'' +
                ", place=" + place +
                ", creator=" + creator +
                '}';
    }
}
