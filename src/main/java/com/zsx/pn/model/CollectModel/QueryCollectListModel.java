package com.zsx.pn.model.CollectModel;

import com.zsx.pn.anotationa.Token;
import com.zsx.pn.model.AbstractPageForm;

import javax.validation.constraints.NotNull;

public class QueryCollectListModel extends AbstractPageForm<QueryCollectListModel> {
    @NotNull(message = "请传入userId")
    private Integer userId;
    @Token
    @NotNull(message = "请传入token")
    private String token;

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
}
