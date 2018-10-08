package com.zsx.pn.web;

import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.entity.Places;
import com.zsx.pn.entity.Tags;
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
    public BaseDto<List<Tags>> getTagsList() {
        try {
            List<Tags> list = tagsService.queryTags();

            return new BaseDto<List<Tags>>("获取列表成功", list, ResCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            return new BaseDto<>(e.getMessage(), ResCodeEnum.FAILURE.getCode());
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

            return new BaseDto("添加标签成功",1);
        } catch (Exception e) {
            if (e.getMessage().equals(Constant.TOKEN_UNVALID_STR)) {
                return new BaseDto(e.getMessage(),ResCodeEnum.UNVALID.getCode());
            }else {
                return new BaseDto(e.getMessage(), ResCodeEnum.FAILURE.getCode());
            }
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

            return new BaseDto("删除标签成功",1);
        } catch (Exception e) {
            if (e.getMessage().equals(Constant.TOKEN_UNVALID_STR)) {
                return new BaseDto(e.getMessage(),ResCodeEnum.UNVALID.getCode());
            }else {
                return new BaseDto(e.getMessage(), ResCodeEnum.FAILURE.getCode());
            }
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

            return new BaseDto("更新标签成功",1);
        } catch (Exception e) {
            if (e.getMessage().equals(Constant.TOKEN_UNVALID_STR)) {
                return new BaseDto(e.getMessage(),ResCodeEnum.UNVALID.getCode());
            }else {
                return new BaseDto(e.getMessage(), ResCodeEnum.FAILURE.getCode());
            }
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
            BaseDto<List<Places>> dto = new BaseDto<>("获取地点成功", list, ResCodeEnum.SUCCESS.getCode());
            System.out.println(dto);
            return dto;
        }catch (Exception e){
            return new BaseDto<>(e.getMessage(),ResCodeEnum.FAILURE.getCode());
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

            return new BaseDto("发布地点成功",ResCodeEnum.SUCCESS.getCode());
        }catch (Exception e) {
            if (e.getMessage().equals(Constant.TOKEN_UNVALID_STR)) {
                return new BaseDto(e.getMessage(),ResCodeEnum.UNVALID.getCode());
            }else {
                return new BaseDto(e.getMessage(), ResCodeEnum.FAILURE.getCode());
            }
        }
    }

    /**
     * 更新地点状态
     * @param model
     * @return
     */
    @RequestMapping(value = "updatePlaceOfState", method = RequestMethod.POST)
    public BaseDto updatePlaceOfState(ChangePlacesStateModel model) {
        try {
            placesService.changePlacesState(model);

            return new BaseDto("更新地点状态成功",ResCodeEnum.SUCCESS.getCode());
        }catch (Exception e) {
            if (e.getMessage().equals(Constant.TOKEN_UNVALID_STR)) {
                return new BaseDto(e.getMessage(),ResCodeEnum.UNVALID.getCode());
            }else {
                return new BaseDto(e.getMessage(), ResCodeEnum.FAILURE.getCode());
            }
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

            return new BaseDto("更新地点信息成功",ResCodeEnum.SUCCESS.getCode());
        }catch (Exception e) {
            if (e.getMessage().equals(Constant.TOKEN_UNVALID_STR)) {
                return new BaseDto(e.getMessage(),ResCodeEnum.UNVALID.getCode());
            }else {
                return new BaseDto(e.getMessage(), ResCodeEnum.FAILURE.getCode());
            }
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

            return new BaseDto("更新地点信息成功",ResCodeEnum.SUCCESS.getCode());
        }catch (Exception e) {
            if (e.getMessage().equals(Constant.TOKEN_UNVALID_STR)) {
                return new BaseDto(e.getMessage(),ResCodeEnum.UNVALID.getCode());
            }else {
                return new BaseDto(e.getMessage(), ResCodeEnum.FAILURE.getCode());
            }
        }
    }
}



