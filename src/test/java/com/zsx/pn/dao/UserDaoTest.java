package com.zsx.pn.dao;

import com.zsx.pn.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("15865987767");
        int res = userDao.insertUser(user);
        System.out.println(res);
    }

    @Test
    public void queryUser() {
        User user = userDao.queryUser("15860763896");
        System.out.println(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setName("15860763896");
        user.setNickName("啊啊啊");
        int res = userDao.updateUser(user);
        System.out.println(res);
    }
}