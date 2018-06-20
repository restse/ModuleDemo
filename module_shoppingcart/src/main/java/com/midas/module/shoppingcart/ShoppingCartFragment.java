package com.midas.module.shoppingcart;

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
 *@time 2018/6/20 12:36
 *@description:
 */
@Route(path = RouteUtils.ShoppingCart_Fragment_Main)
public class ShoppingCartFragment extends BaseFragment {
    private TextView tvLoginState,tvGoodName;
    private Button btGotoGoodDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shoppingcart_fragment_main, null);
        initView(rootView);
        EventBus.getDefault().register(this);
        return rootView;
    }

    private void initView(View rootView) {
        tvGoodName = rootView.findViewById(R.id.tv_goodname);
        tvLoginState = rootView.findViewById(R.id.tv_loginstate);
        btGotoGoodDetail = rootView.findViewById(R.id.bt_goto_gooddetail);
        final String goodName = tvGoodName.getText().toString();
        btGotoGoodDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteUtils.startGoodDetailActivity(goodName);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccess(LoginStateEvent event) {
        if (event.isSuccess) {
            tvLoginState.setText("已登录");
        }
    }
}
