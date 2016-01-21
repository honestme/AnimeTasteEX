package com.honestme.animetasteex;

import android.content.Context;

import com.squareup.otto.Bus;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class Container {
    private Bus mEventBus;
    private Context mContext;

    private static Container mContainer;

    public static Container getInstance(Context context){
        if(mContainer == null){
            mContainer = new Container(context);

        }
        return mContainer;

    }

    private Container(Context context){
        mContext = context;
    }

    public Bus getEventBus(){
        if(mEventBus == null){
            mEventBus = new Bus();
        }
        return mEventBus;

    }
}
