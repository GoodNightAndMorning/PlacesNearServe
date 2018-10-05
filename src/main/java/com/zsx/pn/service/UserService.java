package com.zsx.pn.service;

import com.zsx.pn.entity.User;
import com.zsx.pn.model.UpdateUserModel;
import com.zsx.pn.model.UserLoginModel;

public interface UserService {
    /**
     * 用户登录
     */
    public User login(UserLoginModel loginModel);

    public User updateUser(UpdateUserModel userModel);
}
