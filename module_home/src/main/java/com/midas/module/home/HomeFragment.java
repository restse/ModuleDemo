package com.midas.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.midas.module.base.base.BaseFragment;
import com.midas.module.base.utils.RouteUtils;

/**
 *
 *@author Dell
 *@time 2018/6/20 12:24
 *@description: 主页Fragment
 */
@Route(path = RouteUtils.Home_Fragment_Main)
public class HomeFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment_main,null);
        return rootView;
    }
}
