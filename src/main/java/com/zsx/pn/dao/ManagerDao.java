package com.zsx.pn.dao;

import com.zsx.pn.entity.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerDao {
    /**
     * 根据用户名，密码查找
     * @param name 用户名
     * @param password 密码
     * @return Manager
     */
    Manager queryManager(@Param("name") String name, @Param("password") String password);

    /**
     * 更改密码
     * @param manager
     * @return
     */
    int updatePassword(Manager manager);
}
