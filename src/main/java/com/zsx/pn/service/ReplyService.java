package com.zsx.pn.service;

import com.zsx.pn.entity.Reply;
import com.zsx.pn.model.ReplyModel.AddReplyModel;
import com.zsx.pn.model.ReplyModel.QueryReplyListModel;

import java.util.List;

public interface ReplyService {
    /**
     * 添加回复
     * @param model
     */
    void addReply(AddReplyModel model);

    /**
     * 获取回复列表
     * @param model
     * @return
     */
    List<Reply> queryReplyList(QueryReplyListModel model);
}
