package com.midas.module.find;

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
 *@author midas
 *@time 2018/6/20 12:31
 *@description: 发现页
 */
@Route(path = RouteUtils.Find_Fragment_Main)
public class FindFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.find_fragment_main, null);
        return rootView;
    }
}
