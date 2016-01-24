package com.honestme.animetasteex;

import android.graphics.Movie;

import com.honestme.animetasteex.login.LoginState;
import com.honestme.animetasteex.main.MainPresenter;
import com.honestme.animetasteex.main.MainState;
import com.honestme.animetasteex.main.primary.PrimaryState;

import java.util.List;

/**
 * Created by Administrator on 2016/1/13 0013.
 */
public class ApplicationState implements MainState,PrimaryState,LoginState {

    private static ApplicationState mState;

    private MainPresenter.SlideMenu mMenuItem;

    public static ApplicationState getInstance(){
        if(mState == null){
            synchronized (ApplicationState.class){
                if (mState == null){
                    mState = new ApplicationState();
                }
            }
        }
        return mState;
    }

    private ApplicationState(){}

    @Override
    public void setCollection(List<Movie> collection) {

    }

    @Override
    public void setSelectSlideItem(MainPresenter.SlideMenu item) {
        mMenuItem = item;
    }

    @Override
    public boolean hasCollection() {
        return false;
    }

    @Override
    public void registerForEvents(Object receiver) {

    }

    @Override
    public void unRegisterForEvents(Object receiver) {

    }

    @Override
    public void loginIn(String userName, String passWord, LoginCallbacks loginCallbacks) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getHashPassword() {
        return null;
    }
}
