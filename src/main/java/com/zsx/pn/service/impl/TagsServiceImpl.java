package com.zsx.pn.service.impl;

import com.zsx.pn.dao.TagsDao;
import com.zsx.pn.entity.Tags;
import com.zsx.pn.model.DeleteTagsModel;
import com.zsx.pn.model.InsertTagsModel;
import com.zsx.pn.model.UpdateTagsModel;
import com.zsx.pn.service.RedisService;
import com.zsx.pn.service.TagsService;
import com.zsx.pn.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsDao tagsDao;
    @Autowired
    private RedisService redisService;

    @Override
    public List<Tags> queryTags() {
        List<Tags> list = tagsDao.queryTags();
        return list;
    }

    @Override
    public void insertTags(InsertTagsModel tagsModel) {
        if (tagsModel.getUserId() == null) {
            throw new RuntimeException("请传入userId");
        }
        if (tagsModel.getToken() == null || tagsModel.getToken().equals("")) {
            throw new RuntimeException("请传入token");
        }
        if (!tagsModel.getToken().toString().equals(redisService.get("Manager_" + tagsModel.getUserId().toString()))){
            throw new RuntimeException(Constant.TOKEN_UNVALID_STR);
        }
        if (tagsModel.getTagName() == null || tagsModel.getTagName().equals("")) {
            throw new RuntimeException("请传入标签名称");
        }
        if (tagsModel.getTagCreator() == null || tagsModel.getTagCreator().equals("")) {
            throw new RuntimeException("请传入标签创建者");
        }

        Tags tags = new Tags();
        tags.setName(tagsModel.getTagName());
        tags.setCreator(tagsModel.getTagCreator());

        try {
            int res = tagsDao.insertTags(tags);
            if (res == 0) {
                throw new RuntimeException("添加标签失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("添加标签失败");
        }
    }

    @Override
    public void deleteTags(DeleteTagsModel tagsModel) {
        if (tagsModel.getUserId() == null || tagsModel.getUserId().equals("")) {
            throw new RuntimeException("请传入userId");
        }
        if (tagsModel.getToken() == null || tagsModel.getToken().equals("")) {
            throw new RuntimeException("请传入token");
        }
        if (!tagsModel.getToken().toString().equals(redisService.get("Manager_" + tagsModel.getUserId().toString()))){
            throw new RuntimeException(Constant.TOKEN_UNVALID_STR);
        }
        if (tagsModel.getTagsId() == null) {
            throw new RuntimeException("请传入要删除的标签id");
        }
        try {
            int res = tagsDao.deleteTags(tagsModel.getTagsId());
            if (res == 0) {
                throw new RuntimeException("删除标签失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除标签失败");
        }
    }

    @Override
    public void updateTags(UpdateTagsModel tagsModel) {
        if (tagsModel.getUserId() == null || tagsModel.getUserId().equals("")) {
            throw new RuntimeException("请传入userId");
        }
        if (tagsModel.getToken() == null || tagsModel.getToken().equals("")) {
            throw new RuntimeException("请传入token");
        }
        if (!tagsModel.getToken().toString().equals(redisService.get("Manager_" + tagsModel.getUserId().toString()))){
            throw new RuntimeException(Constant.TOKEN_UNVALID_STR);
        }
        if (tagsModel.getTagName() == null || tagsModel.getTagName().equals("")) {
            throw new RuntimeException("请传入标签名称");
        }
        if (tagsModel.getTagCreator() == null || tagsModel.getTagCreator().equals("")) {
            throw new RuntimeException("请传入标签创建者");
        }
        if (tagsModel.getTagId() == null) {
            throw new RuntimeException("请传入标签id");
        }

        try {
            Tags tags = new Tags();
            tags.setName(tagsModel.getTagName());
            tags.setCreator(tagsModel.getTagCreator());
            tags.setId(tagsModel.getTagId());

            int res = tagsDao.updateTags(tags);

            if (res == 0) {
                throw new RuntimeException("更新标签失败");
            }
        }catch (Exception e) {
            throw new RuntimeException("更新标签失败");
        }
    }
}
