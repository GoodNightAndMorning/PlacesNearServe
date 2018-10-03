package com.zsx.pn.service.impl;

import com.zsx.pn.dao.ManagerDao;
import com.zsx.pn.entity.Manager;
import com.zsx.pn.model.UpdateManagerPwdModel;
import com.zsx.pn.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;


    @Override
    public Manager queryManager(Manager manager) {
        if (manager.getName() == null || manager.getName().equals("")){
            throw new RuntimeException("用户名称不能为空");
        }
        if (manager.getPassword() == null || manager.getPassword().equals("")){
            throw new RuntimeException("用户密码不能为空");
        }

        try {
            Manager model = managerDao.queryManager(manager);
            if (model == null){
                throw new RuntimeException("请输入正确用户名称或密码");
            }
            return model;
        }catch (Exception e){
            throw new RuntimeException("登录失败，" + e.getMessage());
        }
    }

    @Override
    public void updateManager(UpdateManagerPwdModel updateManagerPwdModel) {
        if (updateManagerPwdModel.getManagerId() == null || updateManagerPwdModel.getManagerId().equals("")){
            throw new RuntimeException("请传入管理者id");
        }
        if (updateManagerPwdModel.getPassword() == null || updateManagerPwdModel.getPassword().equals("")){
            throw new RuntimeException("请输入密码");
        }
        if (updateManagerPwdModel.getRePassword() == null || updateManagerPwdModel.getRePassword().equals("")){
            throw new RuntimeException("请再次输入密码");
        }
        if (!(updateManagerPwdModel.getPassword().equals(updateManagerPwdModel.getRePassword()))){
            throw new RuntimeException("两次输入的密码不一致");
        }
        Manager manager = new Manager();
        manager.setId(updateManagerPwdModel.getManagerId());
        manager.setPassword(updateManagerPwdModel.getPassword());
        try {
            Integer res = managerDao.updatePassword(manager);
            if (res == 0) {
                throw new RuntimeException("更改密码失败");
            }
        }catch (Exception e) {
            throw new RuntimeException("更改密码失败，" + e.getMessage());
        }
    }
}
