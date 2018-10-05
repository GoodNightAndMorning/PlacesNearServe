package com.zsx.pn.service;

import com.zsx.pn.entity.Tags;
import com.zsx.pn.model.DeleteTagsModel;
import com.zsx.pn.model.InsertTagsModel;
import com.zsx.pn.model.UpdateTagsModel;

import java.util.List;

public interface TagsService {
    /**
     * 获取标签类别
     * @return
     */
    List<Tags> queryTags();

    /**
     * 添加标签
     * @param tagsModel
     */
    void insertTags(InsertTagsModel tagsModel);

    /**
     * 删除标签
     * @param tagsModel
     * @return
     */
    void deleteTags(DeleteTagsModel tagsModel);

    /**
     * 更新标签
     * @param tagsModel
     * @return
     */
    void updateTags(UpdateTagsModel tagsModel);
}
