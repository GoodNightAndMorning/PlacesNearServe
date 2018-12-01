package com.zsx.pn.dao;

import com.zsx.pn.entity.Love;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoveDaoTest {
    @Autowired
    private LoveDao loveDao;
    @Test
    public void queryLoveList() {
        List<Love> list = loveDao.queryLoveList(1);
        System.out.println(list);
    }

    @Test
    public void addLove() {
        int res = loveDao.addLove(1, 2);
    }

    @Test
    public void cancelLove() {
//        int res = loveDao.cancelLove(2);
    }
}