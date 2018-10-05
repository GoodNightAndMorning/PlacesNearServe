package com.zsx.pn.service.impl;

import com.zsx.pn.dao.UserDao;
import com.zsx.pn.entity.User;
import com.zsx.pn.model.UpdateUserModel;
import com.zsx.pn.model.UserLoginModel;
import com.zsx.pn.service.RedisService;
import com.zsx.pn.service.UserService;
import com.zsx.pn.utils.Constant;
import com.zsx.pn.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisService redisService;

    @Override
    public User login(UserLoginModel loginModel) {
        if (loginModel.getUserName() == null || loginModel.getUserName().equals("")) {
            throw new RuntimeException("请传入手机号码");
        }
        if (!Utils.isMobileNO(loginModel.getUserName())) {
            throw new RuntimeException("请传入正确的手机号码");
        }

        try {
            User user = userDao.queryUser(loginModel.getUserName());
            if (user == null) {
                User user1 = new User();
                user1.setName(loginModel.getUserName());
                int res = userDao.insertUser(user1);
                if (res == 0) {
                    throw new RuntimeException("登录失败");
                }

                user = userDao.queryUser(loginModel.getUserName());
            }
            return user;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User updateUser(UpdateUserModel userModel) {
        if (userModel.getUserId() == null) {
            throw new RuntimeException("请传入用户id");
        }
        if (!userModel.getToken().toString().equals(redisService.get("User_" + userModel.getUserId().toString()))){
            throw new RuntimeException(Constant.TOKEN_UNVALID_STR);
        }

        try {
            User user = userDao.queryUserById(userModel.getUserId());

            if (!(userModel.getNickName() == null || userModel.getNickName().equals(""))) {
                user.setNickName(userModel.getNickName());
            }

            int res = userDao.updateUser(user);

            if (res == 0) {
                throw new RuntimeException("更新用户失败");
            }

            return user;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
