package com.zsx.pn.model.ReplyModel;

import com.zsx.pn.anotationa.Token;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddReplyModel {
    @NotNull(message = "请传入userId")
    private Integer userId;
    @Token
    @NotNull(message = "请传入token")
    private String token;
    @NotNull(message = "请传入评论Id")
    private Integer commentId;
    @NotEmpty(message = "请输入回复内容")
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddReplyModel{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", commentId=" + commentId +
                ", content='" + content + '\'' +
                '}';
    }
}
