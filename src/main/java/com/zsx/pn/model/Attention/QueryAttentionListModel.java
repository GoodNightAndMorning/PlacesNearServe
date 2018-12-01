package com.zsx.pn.model.Attention;

import com.zsx.pn.anotationa.Token;
import com.zsx.pn.model.AbstractPageForm;

import javax.validation.constraints.NotNull;

public class QueryAttentionListModel extends AbstractPageForm<QueryAttentionListModel> {
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
