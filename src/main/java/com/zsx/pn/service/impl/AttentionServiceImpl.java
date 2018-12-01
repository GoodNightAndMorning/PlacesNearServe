package com.zsx.pn.service.impl;

import com.zsx.pn.dao.AttentionDao;
import com.zsx.pn.entity.Attention;
import com.zsx.pn.model.Attention.AddAttentionModel;
import com.zsx.pn.model.Attention.CancelAttentionModel;
import com.zsx.pn.model.Attention.HasAttentionModel;
import com.zsx.pn.model.Attention.QueryAttentionListModel;
import com.zsx.pn.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private AttentionDao attentionDao;

    @Override
    public void addAttention(AddAttentionModel model) {
        try {
            if (model.getUserId() == model.getAuthorId()) {
                throw new RuntimeException("自己不能关注自己");
            }
            Attention attention = attentionDao.getAttention(model.getUserId(),model.getAuthorId());
            if (attention != null) {
                throw new RuntimeException("已经关注过了");
            }
            int res = attentionDao.addAttention(model);
            if (res == 0) {
                throw new RuntimeException("添加关注失败");
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Boolean hasAttention(HasAttentionModel model) {
        try {
            Attention attention = attentionDao.getAttention(model.getUserId(),model.getAuthorId());

            return attention != null;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void cancelAttention(CancelAttentionModel model) {
        try {
            int res = attentionDao.cancelAttention(model);
            if (res == 0) {
                throw new RuntimeException("取消关注失败");
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Attention> queryAttentionList(QueryAttentionListModel model) {
        try {
            List<Attention> list = attentionDao.queryAttentionList(model);
            return list;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
