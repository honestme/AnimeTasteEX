package com.honestme.animetasteex;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by zhangconglin on 2016/1/20.
 */
public class BaseApplication extends com.activeandroid.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
