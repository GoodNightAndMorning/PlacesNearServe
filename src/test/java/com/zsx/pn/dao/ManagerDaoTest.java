package com.zsx.pn.dao;

import com.zsx.pn.entity.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerDaoTest {

    @Autowired
    private ManagerDao managerDao;
    @Test
    public void queryManager() {
//        Manager manager = managerDao.queryManager("admin","123456");
//        System.out.println(manager);
    }

    @Test
    public void updatePassword() {
        Manager manager = new Manager();
        manager.setId(1);
        manager.setName("admin");
        manager.setPassword("666666");
        managerDao.updatePassword(manager);
    }
}