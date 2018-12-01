package com.zsx.pn.dao;

import com.zsx.pn.entity.Collect;
import com.zsx.pn.model.CollectModel.AddCollectModel;
import com.zsx.pn.model.CollectModel.CancelCollectModel;
import com.zsx.pn.model.CollectModel.QueryCollectListModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectDao {
    /**
     * 添加收藏
     * @param model
     * @return
     */
    public int addCollect(AddCollectModel model);

    /**
     * 取消收藏
     * @param model
     * @return
     */
    public int cancelCollect(CancelCollectModel model);
    /**
     * 取消收藏
     * @param model
     * @return
     */
    public int cancelCollectById(CancelCollectModel model);

    /**
     * 获取收藏列表
     * @param model
     * @return
     */
    public List<Collect> queryCollectList(QueryCollectListModel model);

    /**
     * 获取收藏
     * @param userId
     * @return
     */
    public Collect queryCollect(@Param("userId") int userId, @Param("placeId") int placrId);
}
