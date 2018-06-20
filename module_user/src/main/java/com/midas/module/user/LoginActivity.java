package com.midas.module.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.midas.module.base.base.BaseActivity;
import com.midas.module.base.event.LoginStateEvent;
import com.midas.module.base.utils.RouteUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * @author midas
 * @time 2018/6/20 13:39
 * @description: 登录页
 */
@Route(path = RouteUtils.User_Activity_Login)
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtLoginSuccess, mBtLoginFail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_login);
        initView();
        setTitle("登录模块");
    }

    private void initView() {
        mBtLoginSuccess = findViewById(R.id.bt_login_success);
        mBtLoginFail = findViewById(R.id.bt_login_fail);
        mBtLoginFail.setOnClickListener(this);
        mBtLoginSuccess.setOnClickListener(this);
    }

    /**
     * 模块化项目中的onClick、onItemClick等各种回调方法中的不能使用switch (view.getId()) case语句会报错.
     * 需要替换成 if (id == R.id.bt_login_success) else 来替代。
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_login_success) {
            EventBus.getDefault().post(new LoginStateEvent(true));
        } else if (id == R.id.bt_login_fail) {
            EventBus.getDefault().post(new LoginStateEvent(false));
        }
        finish();
    }

}
