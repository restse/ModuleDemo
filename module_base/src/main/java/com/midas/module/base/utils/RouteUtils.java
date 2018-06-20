package com.midas.module.base.utils;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 *
 *@author Dell
 *@time 2018/6/20 10:44
 *@description: 路由管理类
 */
public class RouteUtils {
    public static final String GoodDetail_Activity_Main = "/gooddetail/main";
    public static final String Home_Fragment_Main = "/home/main";
    public static final String Find_Fragment_Main = "/find/main";
    public static final String User_Fragment_Main = "/user/main";
    public static final String User_Activity_Login = "/user/login";
    public static final String ShoppingCart_Fragment_Main = "/shoppingcart/main";

    public static final String Service_User = "/user/service";

    public static Fragment getFindFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(Find_Fragment_Main).navigation();
        return fragment;
    }
    public static Fragment getUserFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(User_Fragment_Main).navigation();
        return fragment;
    }
    public static Fragment getHomeFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(Home_Fragment_Main).navigation();
        return fragment;
    }
    public static Fragment getShoppingCartFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(ShoppingCart_Fragment_Main).navigation();
        return fragment;
    }
    /**商品详情*/
    public static void startGoodDetailActivity(String goodName) {
        ARouter.getInstance().build(GoodDetail_Activity_Main).withString("goodName",goodName).navigation();
    }
    /**登录*/
    public static void startLoginActivity() {
        ARouter.getInstance().build(User_Activity_Login).navigation();
    }
}
