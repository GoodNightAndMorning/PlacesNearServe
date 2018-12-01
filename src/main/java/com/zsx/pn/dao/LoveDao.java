package com.zsx.pn.dao;

import com.zsx.pn.entity.Love;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoveDao {
    /**
     * 获取点赞列表
     * @param placrId
     * @return
     */
    public List<Love> queryLoveList(@Param("placeId") int placrId);
    /**
     * 获取点赞
     * @param placrId
     * @return
     */
    public Love queryLove(@Param("placeId") int placrId, @Param("creatorId") int creatorId);
    /**
     * 点赞
     * @param placreId
     * @param creatorId
     * @return
     */
    public int addLove(@Param("placeId") int placreId, @Param("creatorId") int creatorId);

    /**
     * 取消点赞
     * @param loveId
     * @return
     */
    public int cancelLove(@Param("loveId") int loveId, @Param("creatorId") int creatorId);
}
