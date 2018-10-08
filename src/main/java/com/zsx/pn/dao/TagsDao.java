package com.zsx.pn.dao;

import com.zsx.pn.entity.Tags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagsDao {
    /**
     * 获取标签类别
     * @return
     */
    List<Tags> queryTags();

    /**
     * 添加标签
     */
    int insertTags(Tags tags);

    /**
     * 删除标签
     * @param id
     * @return
     */
    int deleteTags(@Param("tagsId") Integer id);

    /**
     * 更新标签
     * @param tags
     * @return
     */
    int updateTags(Tags tags);

    /**
     * 通过id查找标签
     * @param id
     * @return
     */
    Tags queryTagsById(@Param("id") int id);
}
