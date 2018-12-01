package com.zsx.pn.service.impl;

import com.zsx.pn.dao.ReplyDao;
import com.zsx.pn.entity.Reply;
import com.zsx.pn.model.ReplyModel.AddReplyModel;
import com.zsx.pn.model.ReplyModel.QueryReplyListModel;
import com.zsx.pn.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Override
    public void addReply(AddReplyModel model) {
        try {
            int res = replyDao.addReply(model.getContent(),model.getCommentId(),model.getUserId());
            if (res == 0) {
                throw new RuntimeException("添加回复失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Reply> queryReplyList(QueryReplyListModel model) {
        try {
            List<Reply> list = replyDao.queryReplyList(model.getCommentId());

            return list;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
