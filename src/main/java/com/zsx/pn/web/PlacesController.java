package com.zsx.pn.web;

import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.entity.Tags;
import com.zsx.pn.enumerate.ResCodeEnum;
import com.zsx.pn.model.DeleteTagsModel;
import com.zsx.pn.model.InsertTagsModel;
import com.zsx.pn.model.UpdateTagsModel;
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
}



