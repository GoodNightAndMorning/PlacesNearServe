package com.zsx.pn.dao;

import com.zsx.pn.entity.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyDaoTest {

    @Autowired
    private ReplyDao replyDao;

    @Test
    public void addReply() {
        int res = replyDao.addReply("确实很漂亮啊",1,2);
    }

    @Test
    public void queryReplyList() {
        List<Reply> list = replyDao.queryReplyList(1);
        System.out.println(list);
    }
}