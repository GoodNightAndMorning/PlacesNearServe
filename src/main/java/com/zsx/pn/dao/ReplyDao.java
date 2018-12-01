package com.zsx.pn.dao;

import com.zsx.pn.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyDao {
    /**
     * 添加回复
     * @param content
     * @param commentId
     * @param creatorId
     * @return
     */
    int addReply(@Param("content") String content,
                 @Param("commentId") int commentId,
                 @Param("creatorId") int creatorId);

    /**
     * 获取回复列表
     * @param commentId
     * @return
     */
    List<Reply> queryReplyList(@Param("commentId") int commentId);
}
