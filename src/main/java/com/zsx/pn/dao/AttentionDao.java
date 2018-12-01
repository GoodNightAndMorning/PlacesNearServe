package com.zsx.pn.dao;

import com.zsx.pn.entity.Attention;
import com.zsx.pn.model.Attention.AddAttentionModel;
import com.zsx.pn.model.Attention.CancelAttentionModel;
import com.zsx.pn.model.Attention.HasAttentionModel;
import com.zsx.pn.model.Attention.QueryAttentionListModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttentionDao {
    /**
     * 添加关注
     * @param model
     * @return
     */
    public int addAttention(AddAttentionModel model);

    /**
     * 取消关注
     * @param model
     * @return
     */
    public int cancelAttention(CancelAttentionModel model);

    /**
     * 获取关注列表
     * @param model
     * @return
     */
    public List<Attention> queryAttentionList(QueryAttentionListModel model);

    /**
     * 获取关注
     * @param userId
     * @param authorId
     * @return
     */
    public Attention getAttention(@Param("userId") int userId,
                                  @Param("authorId") int authorId);
}
