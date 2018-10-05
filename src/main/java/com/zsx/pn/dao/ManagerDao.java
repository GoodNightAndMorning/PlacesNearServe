package com.zsx.pn.dao;

import com.zsx.pn.entity.Manager;

public interface ManagerDao {
    /**
     * 根据用户名，密码查找
     * @param manager 密码
     * @return Manager
     */
    Manager queryManager(Manager manager);

    /**
     * 更改密码
     * @param manager
     * @return
     */
    int updatePassword(Manager manager);
}
