package com.zsx.pn.service;

import com.zsx.pn.entity.Attention;
import com.zsx.pn.model.Attention.AddAttentionModel;
import com.zsx.pn.model.Attention.CancelAttentionModel;
import com.zsx.pn.model.Attention.HasAttentionModel;
import com.zsx.pn.model.Attention.QueryAttentionListModel;

import java.util.List;

public interface AttentionService {
    /**
     * 添加关注
     * @param model
     */
    public void addAttention(AddAttentionModel model);

    /**
     * 是否已经添加过收藏
     * @param model
     * @return
     */
    public Boolean hasAttention(HasAttentionModel model);
    /**
     * 取消关注
     * @param model
     */
    public void cancelAttention(CancelAttentionModel model);

    /**
     * 获取关注列表
     * @param model
     * @return
     */
    public List<Attention> queryAttentionList(QueryAttentionListModel model);
}
