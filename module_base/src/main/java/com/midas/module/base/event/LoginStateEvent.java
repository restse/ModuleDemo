package com.midas.module.base.event;

/**
 *
 *@author midas
 *@time 2018/6/20 10:41
 *@description: 登录状态
 */

public class LoginStateEvent {
    public boolean isSuccess;

    public LoginStateEvent(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
