package com.midas.module.user;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.midas.module.base.utils.IUserModuleService;
import com.midas.module.base.utils.RouteUtils;

/**
 *
 *@author midas
 *@time 2018/6/21 9:16
 *@description: 跨模块服务调用
 */
@Route(path = RouteUtils.Service_User)
public class UserModuleServiceImpl implements IUserModuleService {
    @Override
    public String getUserAddress(String userId) {
        return getAddress(userId);
    }

    @Override
    public void init(Context context) {

    }

    public String getAddress(String userId){
        return "北京";
    }
}
