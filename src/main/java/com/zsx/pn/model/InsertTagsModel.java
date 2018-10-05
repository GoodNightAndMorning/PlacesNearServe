package com.zsx.pn.model;

public class InsertTagsModel {
    private Integer userId;
    private String token;
    private String tagName;
    private String tagCreator;

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

    @Override
    public String toString() {
        return "InsertTagsModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", tagName='" + tagName + '\'' +
                ", tagCreator='" + tagCreator + '\'' +
                '}';
    }
}
