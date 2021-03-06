package com.zsx.pn.model.ReplyModel;

import com.zsx.pn.anotationa.Token;

import javax.validation.constraints.NotNull;

public class QueryReplyListModel {
    @NotNull(message = "请传入userId")
    private Integer userId;
    @Token
    @NotNull(message = "请传入token")
    private String token;
    @NotNull(message = "请传入评论Id")
    private Integer commentId;

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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "QueryReplyListModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", commentId=" + commentId +
                '}';
    }
}
