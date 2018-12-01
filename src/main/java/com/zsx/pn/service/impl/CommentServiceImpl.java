package com.zsx.pn.service.impl;

import com.zsx.pn.dao.CommenDao;
import com.zsx.pn.entity.Commen;
import com.zsx.pn.model.CommentModel.AddCommentModel;
import com.zsx.pn.model.CommentModel.DeleteCommentModel;
import com.zsx.pn.model.CommentModel.QueryCommentListModel;
import com.zsx.pn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommenDao commenDao;

    @Transactional
    @Override
    public Commen addComment(AddCommentModel commentModel) {
        try {
            int res = commenDao.addCommnet(commentModel.getPlaceId(),
                    commentModel.getContent(),
                    commentModel.getUserId());

            if (res == 0) {
                throw new RuntimeException("添加评论失败");
            }

            Commen commen = commenDao.getLastComment();

            if (commen == null) {
                throw new RuntimeException("添加评论失败");
            }

            return commen;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteComment(DeleteCommentModel commentModel) {
        try {
            int res = commenDao.delectComment(commentModel.getCommentId());
            if (res == 0) {
                throw new RuntimeException("删除评论失败");
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Commen> queryCommentList(QueryCommentListModel model) {
        try {
            List<Commen> list = commenDao.queryCommentList(model.getPlaceId());
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
