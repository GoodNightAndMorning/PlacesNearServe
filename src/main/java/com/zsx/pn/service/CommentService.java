package com.zsx.pn.service;

import com.zsx.pn.entity.Commen;
import com.zsx.pn.model.CommentModel.AddCommentModel;
import com.zsx.pn.model.CommentModel.DeleteCommentModel;
import com.zsx.pn.model.CommentModel.QueryCommentListModel;

import java.util.List;

public interface CommentService {
    /**
     * 添加评论
     * @param commentModel
     */
    Commen addComment(AddCommentModel commentModel);
    /**
     * 删除评论
     * @param commentModel
     */
    void deleteComment(DeleteCommentModel commentModel);

    /**
     * 获取评论列表
     * @param model
     * @return
     */
    List<Commen> queryCommentList(QueryCommentListModel model);
}
