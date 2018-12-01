package com.zsx.pn.model.CommentModel;

import com.zsx.pn.anotationa.Token;
import com.zsx.pn.model.AbstractPageForm;

import javax.validation.constraints.NotNull;

public class QueryCommentListModel extends AbstractPageForm<QueryCommentListModel> {
    @Token
    @NotNull(message = "请传入token")
    private String token;
    @NotNull(message = "请传入地点Id")
    private Integer placeId;

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

    @Override
    public String toString() {
        return "QueryCommentListModel{" +
                ", token='" + token + '\'' +
                ", placeId=" + placeId +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
