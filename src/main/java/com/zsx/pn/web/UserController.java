package com.zsx.pn.web;

import com.zsx.pn.dto.BaseDto;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseDto<UserLoginDto> login(UserLoginModel loginModel) {
        try {
            User user = userService.login(loginModel);

            UserLoginDto dto = new UserLoginDto();

            dto.setName(user.getName());
            dto.setId(user.getId());
            dto.setNickName(user.getNickName());

            String token = Utils.createToken(user.getId().toString());

            dto.setToken(token);

            redisService.set("User_" + user.getId().toString(), token);

            return new BaseDto<UserLoginDto>("登录成功",dto,ResCodeEnum.SUCCESS.getCode());
        }catch (Exception e) {
            return new BaseDto<>(e.getMessage(), ResCodeEnum.FAILURE.getCode());
        }
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public BaseDto<UserLoginDto> updateUser(UpdateUserModel userModel) {
        try {
            User user = userService.updateUser(userModel);

            UserLoginDto dto = new UserLoginDto();
            dto.setNickName(user.getNickName());

            return new BaseDto<UserLoginDto>("更新用户成功", dto, ResCodeEnum.SUCCESS.getCode());
        }catch (Exception e) {
            if (e.getMessage().equals(Constant.TOKEN_UNVALID_STR)) {
                return new BaseDto(e.getMessage(),ResCodeEnum.UNVALID.getCode());
            }else {
                return new BaseDto(e.getMessage(), ResCodeEnum.FAILURE.getCode());
            }
        }

    }
}
