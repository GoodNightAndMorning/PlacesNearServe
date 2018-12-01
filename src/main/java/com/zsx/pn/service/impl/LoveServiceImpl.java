package com.zsx.pn.service.impl;

import com.zsx.pn.dao.LoveDao;
import com.zsx.pn.entity.Love;
import com.zsx.pn.model.AddLoveModel;
import com.zsx.pn.model.CancelLoveModel;
import com.zsx.pn.model.QueryLoveListModel;
import com.zsx.pn.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoveServiceImpl implements LoveService {

    @Autowired
    private LoveDao loveDao;

    @Override
    public void addLove(AddLoveModel loveModel) {
        try {

            Love love = loveDao.queryLove(loveModel.getPlaceId(), loveModel.getUserId());

            if (love == null) {
                int res = loveDao.addLove(loveModel.getPlaceId(), loveModel.getUserId());
                if (res == 0) {
                    throw new RuntimeException("点赞失败");
                }
            }else {
                throw new RuntimeException("已经点赞过啦");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Love> queryLoveList(QueryLoveListModel loveListModel) {
        try {
            List<Love> list = loveDao.queryLoveList(loveListModel.getPlaceId());

            return list;
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void cancelLove(CancelLoveModel loveModel) {
        try {
            int res = loveDao.cancelLove(loveModel.getLoveId(),loveModel.getUserId());
            if (res == 0) {
                throw new RuntimeException("取消点赞失败");
            }
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }
    }
}
