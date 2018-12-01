package com.zsx.pn.dao;

import com.zsx.pn.entity.Commen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommenDaoTest {

    @Autowired
    private CommenDao commenDao;

    @Test
    public void addCommnet() {
        int res = commenDao.addCommnet(1, "好漂亮啊", 2);
    }

    @Test
    public void queryCommentList() {
        List<Commen> list = commenDao.queryCommentList(1);
        System.out.println(list);
    }

    @Test
    public void delectComment() {
        int res = commenDao.delectComment(1);
    }
}