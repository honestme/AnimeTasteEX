package com.honestme.animetasteex;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.honestme.animetasteex.main.MainPresenter;

/**
 * Created by zhangconglin on 2016/1/20.
 */
public class BaseApplication extends com.activeandroid.app.Application{
    private MainPresenter mMainPresenter;

    public static BaseApplication from(Context context){
        return (BaseApplication)context.getApplicationContext();
    }

    public MainPresenter getMainPresenter(){
        return mMainPresenter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
