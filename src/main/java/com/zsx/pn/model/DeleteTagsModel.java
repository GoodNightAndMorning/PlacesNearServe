package com.zsx.pn.model;

public class DeleteTagsModel {
    private Integer userId;
    private String token;
    private Integer tagsId;

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

    public Integer getTagsId() {
        return tagsId;
    }

    public void setTagsId(Integer tagsId) {
        this.tagsId = tagsId;
    }

    @Override
    public String toString() {
        return "DeleteTagsModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", tagsId=" + tagsId +
                '}';
    }
}
