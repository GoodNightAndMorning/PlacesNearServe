package com.zsx.pn.dao;

import com.zsx.pn.entity.Commen;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommenDao {
    /**
     * 添加评论
     * @param placeId
     * @param content
     * @param creatorId
     * @return
     */
    int addCommnet(@Param("placeId") int placeId,
                   @Param("content") String content,
                   @Param("creatorId") int creatorId);

    /**
     * 获取评论列表
     * @param placeId
     * @return
     */
    List<Commen> queryCommentList(@Param("placeId") int placeId);

    /**
     * 获取客户端最新添加的评论
     * @return
     */
    Commen getLastComment();

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    int delectComment(@Param("commentId") int commentId);
}
