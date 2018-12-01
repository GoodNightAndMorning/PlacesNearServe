package com.zsx.pn.model.CommentModel;

import com.zsx.pn.anotationa.Token;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddCommentModel {
    @NotNull(message = "请传入userId")
    private Integer userId;
    @Token
    @NotNull(message = "请传入token")
    private String token;
    @NotNull(message = "请传入地点Id")
    private Integer placeId;
    @NotEmpty(message = "请输入评论内容")
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddCommentModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", placeId=" + placeId +
                ", content='" + content + '\'' +
                '}';
    }
}
