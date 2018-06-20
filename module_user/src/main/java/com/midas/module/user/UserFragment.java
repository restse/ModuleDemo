package com.midas.module.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.midas.module.base.base.BaseFragment;
import com.midas.module.base.event.LoginStateEvent;
import com.midas.module.base.utils.RouteUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 *
 *@author midas
 *@time 2018/6/20 13:26
 *@description: 用户模块
 */
@Route(path = RouteUtils.User_Fragment_Main)
public class UserFragment extends BaseFragment {
    private TextView tv_login_state;
    private Button bt_login_state;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.user_fragment_main,null);
        initView(rootView);
        EventBus.getDefault().register(this);
        return rootView;
    }

    private void initView(View rootView) {
        bt_login_state = rootView.findViewById(R.id.bt_login);
        tv_login_state = rootView.findViewById(R.id.tv_login_state);
        bt_login_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteUtils.startLoginActivity();
            }
        });
    }
    /**登录状态*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccess(LoginStateEvent loginStateEvent){
        if (loginStateEvent.isSuccess){
            tv_login_state.setText("已登录");
        }
    }
}
