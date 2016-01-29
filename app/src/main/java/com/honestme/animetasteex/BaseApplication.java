package com.honestme.animetasteex;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.honestme.animetasteex.main.MainPresenter;
import com.honestme.animetasteex.util.IInjector;

import dagger.ObjectGraph;

/**
 * Created by zhangconglin on 2016/1/20.
 */
public class BaseApplication extends com.activeandroid.app.Application implements IInjector{
    private MainPresenter mMainPresenter;
    private ObjectGraph mObjectGraph;

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
        mObjectGraph = ObjectGraph.create();
        mObjectGraph.inject(this);
    }

    @Override
    public void inject(Object object) {
        mObjectGraph.inject(object);
    }
}

