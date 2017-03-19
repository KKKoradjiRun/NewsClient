package com.tomas.snowfat.newsclient.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 *
 * Created by Tomas on 2017/3/16.
 */

/**
 * 封装一些公共的功能
 * 有利于项目的扩展和维护
 *
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        //集成butterknife
        ButterKnife.bind(this);
        init();
    }

    protected void init(){

    }

    /**
     *
     * 子类必须实现这个方法 返回布局id
     * @return
     */
    public abstract int getLayoutResID();
    public void jumpTo(Context context, Class activity){
        Intent intent = new Intent(context,activity);
        startActivity(intent);
        finish();

    }
}
