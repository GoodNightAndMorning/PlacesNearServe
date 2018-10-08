package com.zsx.pn.service;

import com.zsx.pn.entity.Places;
import com.zsx.pn.model.ChangePlacesStateModel;
import com.zsx.pn.model.DeletePlacesModel;
import com.zsx.pn.model.PublishPlacesModel;
import com.zsx.pn.model.QueryPlacesModel;

import java.util.List;

public interface PlacesService {
    /**
     * 获取地点列表
     * @param model
     * @return
     */
    List<Places> queryPlaces(QueryPlacesModel model);

    /**
     * 发布地点
     * @param model
     */
    void publishPlaces(PublishPlacesModel model);

    /**
     * 改变地点发布状态
     * @param model
     */
    void changePlacesState(ChangePlacesStateModel model);

    /**
     * 更新地点信息
     * @param model
     */
    void updatePlaces(PublishPlacesModel model);

    /**
     * 删除地点
     * @param model
     */
    void deletePlaces(DeletePlacesModel model);
}
