package com.zsx.pn.service;

import com.zsx.pn.entity.Collect;
import com.zsx.pn.model.CollectModel.AddCollectModel;
import com.zsx.pn.model.CollectModel.CancelCollectModel;
import com.zsx.pn.model.CollectModel.QueryCollectListModel;

import java.util.List;

public interface CollectService {
    /**
     * 收藏
     * @param model
     */
    void addCollect(AddCollectModel model);

    /**
     * 取消收藏
     * @param model
     */
    void cancelCollect(CancelCollectModel model);

    /**
     * 获取收藏列表
     * @param model
     * @return
     */
    List<Collect> queryCollectList(QueryCollectListModel model);
}
