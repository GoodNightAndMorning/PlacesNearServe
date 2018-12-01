package com.zsx.pn.dao;

import com.zsx.pn.model.Attention.AddAttentionModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttentionDaoTest {

    @Autowired
    private AttentionDao attentionDao;
    @Test
    public void addAttention() {
        AddAttentionModel model = new AddAttentionModel();
        model.setAuthorId(1);
        model.setUserId(1);
        int res = attentionDao.addAttention(model);
        System.out.println("=======>> " + res);
    }

    @Test
    public void cancelAttention() {
    }

    @Test
    public void queryAttentionList() {
    }

    @Test
    public void getAttention() {
    }
}