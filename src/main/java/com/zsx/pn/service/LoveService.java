package com.zsx.pn.service;

import com.zsx.pn.entity.Love;
import com.zsx.pn.model.AddLoveModel;
import com.zsx.pn.model.CancelLoveModel;
import com.zsx.pn.model.QueryLoveListModel;

import java.util.List;

public interface LoveService {

    /**
     * 添加赞
     * @param loveModel
     */
    void addLove(AddLoveModel loveModel);

    /**
     * 获取点赞列表
     * @param loveListModel
     * @return
     */
    List<Love> queryLoveList(QueryLoveListModel loveListModel);

    /**
     * 取消赞
     * @param loveModel
     */
    void cancelLove(CancelLoveModel loveModel);
}
