package com.midas.module.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.midas.module.base.base.BaseActivity;
import com.midas.module.base.utils.RouteUtils;


/**
 * @author midas
 * @time 2018/6/20 13:59
 * @description: 商品详情
 */
@Route(path = RouteUtils.GoodDetail_Activity_Main)
public class GoodDetailActivity extends BaseActivity {
    private TextView tvGoodName,tv_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gooddetail_activity_main);
        tvGoodName = findViewById(R.id.tv_good_name);
        tv_address = findViewById(R.id.tv_address);
        initData();
        setTitle("商品详情模块");

    }

    private void initData() {
        Intent intent = getIntent();
        String goodName = intent.getStringExtra("goodName");
        tvGoodName.setText(goodName);
        //tv_address.setText("用户所在地址:"+ ModuleRouteService.getUserAddress("123"));
    }
}
