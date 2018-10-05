package com.zsx.pn.dao;

import com.zsx.pn.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户名查找user
     * @param name
     * @return
     */
    User queryUser(@Param("name") String name);
    /**
     * 根据id查找user
     * @param id
     * @return
     */
    User queryUserById(@Param("id") Integer id);

    /**
     * 更新User
     * @param user
     * @return
     */
    int updateUser(User user);
}
