package com.zsx.pn.service.impl;

import com.zsx.pn.dao.PlacesDao;
import com.zsx.pn.entity.Places;
import com.zsx.pn.model.ChangePlacesStateModel;
import com.zsx.pn.model.DeletePlacesModel;
import com.zsx.pn.model.PublishPlacesModel;
import com.zsx.pn.model.QueryPlacesModel;
import com.zsx.pn.service.PlacesService;
import com.zsx.pn.service.RedisService;
import com.zsx.pn.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesServiceImpl implements PlacesService {

    @Autowired
    private PlacesDao placesDao;
    @Autowired
    private RedisService redisService;

    @Override
    public List<Places> queryPlaces(QueryPlacesModel model) {

        List<Places> list = null;

        try {
            list = placesDao.queryPlacesList(model.getUserId());
            return list;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void publishPlaces(PublishPlacesModel model) {
        if (model.getUserId() == null) {
            throw new RuntimeException("请传入userId");
        }
        if (model.getToken() == null || model.getToken().equals("")) {
            throw new RuntimeException("请传入token");
        }
        if (!model.getToken().toString().equals(redisService.get("User_" + model.getUserId().toString()))){
            throw new RuntimeException(Constant.TOKEN_UNVALID_STR);
        }

        if (model.getPlaceName() == null || model.getPlaceName().equals("")){
            throw new RuntimeException("请传入地点名称");
        }
        if (model.getTagId() == null){
            throw new RuntimeException("请传入地点标签id");
        }
        if (model.getLongitude() == null || model.getLatitude() == null) {
            throw new RuntimeException("请传入经纬度");
        }

        try {
            Places places = new Places();
            places.setCreatorId(model.getUserId());
            places.setPlaceName(model.getPlaceName());
            places.setPlaceDesc(model.getPlaceDesc());

            places.setPlacePhotos(model.getPlacePhotos());
            places.setTagId(model.getTagId());
            places.setLatitude(model.getLatitude());
            places.setLongitude(model.getLongitude());

            int res = placesDao.insertPlaces(places);
            if (res == 0) {
                throw new RuntimeException("发布点点失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public void updatePlaces(PublishPlacesModel model) {
        if (model.getUserId() == null) {
            throw new RuntimeException("请传入userId");
        }
        if (model.getToken() == null || model.getToken().equals("")) {
            throw new RuntimeException("请传入token");
        }
        if (!model.getToken().toString().equals(redisService.get("User_" + model.getUserId().toString()))){
            throw new RuntimeException(Constant.TOKEN_UNVALID_STR);
        }
        try {
            Places places = placesDao.queryPlaceById(model.getId());
            if (!(model.getPlaceName() == null || model.getPlaceName().equals(""))){
                places.setPlaceName(model.getPlaceName());
            }
            if (!(model.getPlaceDesc() == null || model.getPlaceDesc().equals(""))){
                places.setPlaceDesc(model.getPlaceDesc());
            }
            if (!(model.getPlacePhotos() == null || model.getPlacePhotos().equals(""))){
                places.setPlacePhotos(model.getPlacePhotos());
            }
            if (!(model.getTagId() == null || model.getTagId().equals(""))){
                places.setTagId(model.getTagId());
            }
            if (!(model.getLatitude() == null || model.getLatitude().equals(""))){
                places.setLatitude(model.getLatitude());
            }
            if (!(model.getLongitude() == null || model.getLongitude().equals(""))){
                places.setLongitude(model.getLongitude());
            }
            int res = placesDao.insertPlaces(places);
            if (res == 0) {
                throw new RuntimeException("发布点点失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletePlaces(DeletePlacesModel model) {
        if (model.getUserId() == null) {
            throw new RuntimeException("请传入userId");
        }
        if (model.getToken() == null || model.getToken().equals("")) {
            throw new RuntimeException("请传入token");
        }
        if (!model.getToken().toString().equals(redisService.get("User_" + model.getUserId().toString()))){
            throw new RuntimeException(Constant.TOKEN_UNVALID_STR);
        }

        if (model.getPlaceId() == null) {
            throw new RuntimeException("请常茹地点id");
        }
        try {
            int res = placesDao.deletePlaces(model.getPlaceId());
            if (res == 0) {
                throw new RuntimeException("删除地点失败");
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
