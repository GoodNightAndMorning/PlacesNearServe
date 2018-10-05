package com.zsx.pn.model;

public class UpdateTagsModel {
    private Integer userId;
    private String token;
    private String tagName;
    private String tagCreator;
    private Integer tagId;

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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagCreator() {
        return tagCreator;
    }

    public void setTagCreator(String tagCreator) {
        this.tagCreator = tagCreator;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "UpdateTagsModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", tagName='" + tagName + '\'' +
                ", tagCreator='" + tagCreator + '\'' +
                ", tagId='" + tagId + '\'' +
                '}';
    }
}
