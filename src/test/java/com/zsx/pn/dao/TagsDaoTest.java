package com.zsx.pn.dao;

import com.zsx.pn.entity.Tags;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagsDaoTest {

    @Autowired
    private TagsDao tagsDao;
    @Test
    public void queryTags() {
        List<Tags> tags = tagsDao.queryTags();
        System.out.println(tags);
    }

    @Test
    public void insertTags() {
        Tags tags = new Tags();
        tags.setName("地铁站");
        tags.setCreator("admin");
        int res = tagsDao.insertTags(tags);
        System.out.println(res);
    }

    @Test
    public void deleteTags() {
        int res = tagsDao.deleteTags(2);
        System.out.println(res);
    }

    @Test
    public void updateTags() {
        Tags tags = new Tags();
        tags.setName("公交站xxx");
        tags.setCreator("admin");
        tags.setId(1);
        int res = tagsDao.updateTags(tags);
        System.out.println(res);
    }
}