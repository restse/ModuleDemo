package com.midas.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.midas.module.home.HomeActivity;

/**
 *
 *@author midas
 *@time 2018/6/20 10:32
 *@description: 模块化项目demo
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
