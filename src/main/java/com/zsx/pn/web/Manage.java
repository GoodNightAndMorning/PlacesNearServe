package com.zsx.pn.web;

import com.zsx.pn.dto.BaseDto;
import com.zsx.pn.dto.ManagerLoginDto;
import com.zsx.pn.entity.Manager;
import com.zsx.pn.service.ManagerService;
import com.zsx.pn.service.RedisService;
import com.zsx.pn.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class Manage {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private RedisService redisService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseDto<ManagerLoginDto> login(Manager manager){

        try {
            Manager m = managerService.queryManager(manager);

            ManagerLoginDto loginDto = new ManagerLoginDto();

            loginDto.setManagerId(m.getId());
            loginDto.setManagerName(m.getName());

            String token = Utils.createToken(m.getId().toString());

            loginDto.setToken(token);

            redisService.set("Manager_" + m.getId().toString(), token, 3600L);

            return new BaseDto<ManagerLoginDto>("登录成功", loginDto, 1);
        }catch (Exception e){
            return new BaseDto<>(e.getMessage(), 0);
        }
    }
}
