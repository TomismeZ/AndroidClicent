package com.example.zdk.androidclient;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);//Xutils初始化
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
