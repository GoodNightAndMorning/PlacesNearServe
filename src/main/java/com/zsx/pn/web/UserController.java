package com.zsx.pn.web;

import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.BaseResult;
import com.zsx.pn.dto.UserLoginDto;
import com.zsx.pn.entity.User;
import com.zsx.pn.enumerate.ResCodeEnum;
import com.zsx.pn.model.UpdateUserModel;
import com.zsx.pn.model.UserLoginModel;
import com.zsx.pn.service.RedisService;
import com.zsx.pn.service.UserService;
import com.zsx.pn.utils.Constant;
import com.zsx.pn.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseDto<UserLoginDto> login(@Valid UserLoginModel loginModel,
                                       BindingResult result) {

        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            User user = userService.login(loginModel);

            UserLoginDto dto = new UserLoginDto();

            dto.setName(user.getName());
            dto.setId(user.getId());
            dto.setNickName(user.getNickName());

            String token = Utils.createToken(user.getId().toString());

            dto.setToken(token);

            redisService.set("User_" + user.getId().toString(), token);

            return BaseResult.success(dto, "登录成功");
        }catch (Exception e) {

            return BaseResult.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public BaseDto<UserLoginDto> updateUser(@Valid UpdateUserModel userModel,
                                            BindingResult result) {
        String message = BaseResult.vaildParams(result);
        if (message != null) {
            return BaseResult.failure(message);
        }

        try {
            User user = userService.updateUser(userModel);

            UserLoginDto dto = new UserLoginDto();
            dto.setNickName(user.getNickName());

            return BaseResult.success("更新用户信息成功");
        }catch (Exception e) {
            return BaseResult.failure(e.getMessage());
        }

    }
}
