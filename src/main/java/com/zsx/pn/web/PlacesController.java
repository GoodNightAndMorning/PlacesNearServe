package com.zsx.pn.web;

import com.github.pagehelper.PageInfo;
import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.entity.Places;
import com.zsx.pn.entity.Tags;
import com.zsx.pn.entity.User;
import com.zsx.pn.enumerate.ResCodeEnum;
import com.zsx.pn.model.*;
import com.zsx.pn.service.PlacesService;
import com.zsx.pn.service.TagsService;
import com.zsx.pn.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("places")
public class PlacesController {
    @Autowired
    private TagsService tagsService;

    @Autowired
    private PlacesService placesService;
    /**
     * 获取标签列表
     * @return
     */
    @RequestMapping(value = "getTagsList", method = RequestMethod.GET)
    public BaseDto<PageInfo<Tags>> getTagsList(GetTagsListModel listModel) {
        try {
            listModel.enablePaging();
            List<Tags> list = tagsService.queryTags();
            PageInfo<Tags> pageInfo = new PageInfo<Tags>(list);

            return BaseResult.success(pageInfo, "获取列表成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 添加标签
     * @param tagsModel
     * @return
     */
    @RequestMapping(value = "addTag", method = RequestMethod.POST)
    public BaseDto addTag(InsertTagsModel tagsModel) {
        try {
            tagsService.insertTags(tagsModel);

            return BaseResult.success(null, "添加标签成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 删除标签
     * @param tagsModel
     * @return
     */
    @RequestMapping(value = "deleteTag", method = RequestMethod.POST)
    public BaseDto deleteTag(DeleteTagsModel tagsModel) {
        try {
            tagsService.deleteTags(tagsModel);

            return BaseResult.success(null, "删除标签成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 更新标签
     * @param tagsModel
     * @return
     */
    @RequestMapping(value = "updateTag", method = RequestMethod.POST)
    public BaseDto updateTag(UpdateTagsModel tagsModel) {
        try {
            tagsService.updateTags(tagsModel);

            return BaseResult.success(null, "更新标签成功");
        } catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 获取地点列表
     * @param model
     * @return
     */
    @RequestMapping(value = "queryPlacesList", method = RequestMethod.GET)
    public BaseDto<List<Places>> queryPlacesList(QueryPlacesModel model) {
        try {
            List<Places> list = placesService.queryPlaces(model);

            return BaseResult.success(list, "获取地点成功");
        }catch (Exception e){
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 发布地点
     * @param model
     * @return
     */
    @RequestMapping(value = "publishPlaces", method = RequestMethod.POST)
    public BaseDto publishPlaces(PublishPlacesModel model) {
        try {
            placesService.publishPlaces(model);

            return BaseResult.success(null, "发布地点成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 更新地点信息
     * @param model
     * @return
     */
    @RequestMapping(value = "updatePlace", method = RequestMethod.POST)
    public BaseDto updatePlace(PublishPlacesModel model) {
        try {
            placesService.updatePlaces(model);

            return BaseResult.success("更新地点信息成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }

    /**
     * 删除地点
     * @param model
     * @return
     */
    @RequestMapping(value = "deletePlace", method = RequestMethod.POST)
    public BaseDto deletePlace(DeletePlacesModel model) {
        try {
            placesService.deletePlaces(model);
            return BaseResult.success("删除地点信息成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }
    }
}



