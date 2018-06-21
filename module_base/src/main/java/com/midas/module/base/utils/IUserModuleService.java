package com.midas.module.base.utils;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author midas
 * @time 2018/6/21 9:20
 * @description: 跨模块的服务调用
 */
public interface IUserModuleService extends IProvider {
    /**
     * 获取地址
     *
     * @param userId
     * @return
     */
    String getUserAddress(String userId);
}
