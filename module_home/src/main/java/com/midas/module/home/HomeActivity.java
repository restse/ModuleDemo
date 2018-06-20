package com.midas.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.midas.module.base.base.BaseActivity;
import com.midas.module.base.utils.RouteUtils;

/**
 * @author midas
 * @time 2018/6/20 11:06
 * @description:
 */
public class HomeActivity extends BaseActivity {


    /**
     * 在注解@BindView的时候，只需要把R.id.rg_tab换成R2.id.rg_tab，library中R中id不是常量，所以会找不到这个id，
     * 而butterknife的插件会自动帮我们生成R2文件，里面的id是常量类型，所以只需要把R替换成R2即可。
     *
     * @BindView(R2.id.rb_home)
     */
    private RadioGroup rgTab;
    private RadioButton rbHome, rbFind, rbShoppingCart, rbUser;
    private FragmentManager supportFragmentManager;
    private Fragment curFragment, mHomeFragment, mFindFragment, mShoppingCartFragment, mUserFragment;
    public static final String TAG_FRAGMENT_HOME = "home";
    public static final String TAG_FRAGMENT_FIND = "find";
    public static final String TAG_FRAGMENT_CART = "cart";
    public static final String TAG_FRAGMENT_USER = "user";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        supportFragmentManager = getSupportFragmentManager();
        initView();

    }

    private void initView() {
        rbHome = findViewById(R.id.rb_home);
        rbFind = findViewById(R.id.rb_find);
        rbShoppingCart = findViewById(R.id.rb_shoppingcart);
        rbUser = findViewById(R.id.rb_user);
        rgTab = findViewById(R.id.rg_tab);
        // 底部tab切换监听
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switchTab(checkedId);
            }
        });
        switchTab(R.id.rb_home);
    }

    private void switchTab(int checkedId) {
        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        hideAllFragment(ft);
        if (checkedId == R.id.rb_home) {
            mHomeFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_HOME);
            if (mHomeFragment == null) {
                mHomeFragment = RouteUtils.getHomeFragment();
                if (mHomeFragment != null) {
                    ft.add(R.id.ll_main, mHomeFragment, TAG_FRAGMENT_HOME);
                }
            }
            curFragment = mHomeFragment;
        } else if (checkedId == R.id.rb_find) {
            mFindFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_FIND);
            if (mFindFragment == null) {
                mFindFragment = RouteUtils.getFindFragment();
                if (mFindFragment != null) {
                    ft.add(R.id.ll_main, mFindFragment, TAG_FRAGMENT_FIND);
                }
            }
            curFragment = mFindFragment;
        } else if (checkedId == R.id.rb_shoppingcart) {
            mShoppingCartFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_CART);
            if (mShoppingCartFragment == null) {
                mShoppingCartFragment = RouteUtils.getShoppingCartFragment();
                if (mShoppingCartFragment != null) {
                    ft.add(R.id.ll_main, mShoppingCartFragment, TAG_FRAGMENT_CART);
                }
            }
            curFragment = mShoppingCartFragment;
        } else if (checkedId == R.id.rb_user) {
            mUserFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_USER);
            if (mUserFragment == null) {
                mUserFragment = RouteUtils.getUserFragment();
                if (mUserFragment != null) {
                    ft.add(R.id.ll_main, mUserFragment, TAG_FRAGMENT_USER);
                }
            }
            curFragment = mUserFragment;
        }
        if (curFragment != null) {
            ft.show(curFragment).commit();
        }
    }

    private void hideAllFragment(FragmentTransaction ft) {
        Fragment fragment;
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_HOME);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_FIND);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_CART);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_USER);
        if (fragment != null) {
            ft.hide(fragment);
        }
    }
}
