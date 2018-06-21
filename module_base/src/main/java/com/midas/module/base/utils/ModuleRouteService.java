package com.midas.module.base.utils;

import com.alibaba.android.arouter.launcher.ARouter;
/**
 *
 *@author midas
 *@time 2018/6/21 9:23
 *@description: 跨模块服务调用
 */
public class ModuleRouteService{
    public static String getUserAddress(String userId){
        IUserModuleService iUserModuleService = ARouter.getInstance().navigation(IUserModuleService.class);
        if (iUserModuleService != null){
            return iUserModuleService.getUserAddress(userId);
        }
        return "";
    }
}
