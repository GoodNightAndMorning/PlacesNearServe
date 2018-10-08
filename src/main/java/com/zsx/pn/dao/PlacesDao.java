package com.zsx.pn.dao;

import com.zsx.pn.entity.Places;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlacesDao {
    /**
     * 根据是否发布获取地点列表
     * @param state 0：待审核，1：审核通过，2：拒绝
     * @return
     */
    List<Places> queryPlacesListByState(@Param("state") int state);

    /**
     * 获取所以地点
     * @return
     */
    List<Places> queryPlacesList();
    /**
     * 根据id获取地点
     * @return
     */
    Places queryPlaceById(@Param("id") int id);

    /**
     * 添加地点
     * @param places
     * @return
     */
    int insertPlaces(Places places);

    /**
     * 更新地点状态
     * @param id
     * @param state
     * @return
     */
    int updatePlacesOfState(@Param("id") int id, @Param("state") int state);

    /**
     * 更新地点信息
     * @param places
     * @return
     */
    int updatePlaces(Places places);

    /**
     * 删除地点
     * @param id
     * @return
     */
    int deletePlaces(@Param("id") int id);
}
