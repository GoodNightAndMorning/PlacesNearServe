package com.zsx.pn.entity;

public class Reply {

    private Integer id;
    private String content;
    private Integer commentId;
    private Integer creatorId;
    private String createTime;

    private Commen commen;
    private User creator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public Commen getCommen() {
        return commen;
    }

    public void setCommen(Commen commen) {
        this.commen = commen;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", commentId=" + commentId +
                ", creatorId=" + creatorId +
                ", createTime='" + createTime + '\'' +
                ", commen=" + commen +
                ", creator=" + creator +
                '}';
    }
}
