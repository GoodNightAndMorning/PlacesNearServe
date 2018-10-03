package com.zsx.pn.service;

import com.zsx.pn.entity.Manager;
import com.zsx.pn.model.UpdateManagerPwdModel;

public interface ManagerService {
    /**
     * 查找用户
     * @param manager
     * @return
     */
     Manager queryManager(Manager manager);

    /**
     * 更新管理者
     * @param updateManagerPwdModel
     */
     void updateManager(UpdateManagerPwdModel updateManagerPwdModel);
}
