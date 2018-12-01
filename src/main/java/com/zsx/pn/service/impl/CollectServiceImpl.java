package com.zsx.pn.service.impl;

import com.zsx.pn.dao.CollectDao;
import com.zsx.pn.entity.Collect;
import com.zsx.pn.entity.Love;
import com.zsx.pn.model.CollectModel.AddCollectModel;
import com.zsx.pn.model.CollectModel.CancelCollectModel;
import com.zsx.pn.model.CollectModel.QueryCollectListModel;
import com.zsx.pn.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;

    @Override
    public void addCollect(AddCollectModel model) {
        try {

            Collect collect = collectDao.queryCollect(model.getUserId(), model.getPlaceId());

            if (collect == null) {
                int res = collectDao.addCollect(model);
                if (res == 0) {
                    throw new RuntimeException("收藏失败");
                }
            }else {
                throw new RuntimeException("已经收藏过啦");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void cancelCollect(CancelCollectModel model) {
        try {
            int res = collectDao.cancelCollect(model);
            if (res == 0) {
                throw new RuntimeException("取消收藏失败");
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Collect> queryCollectList(QueryCollectListModel model) {
        try {
            List<Collect> list = collectDao.queryCollectList(model);
            return list;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
