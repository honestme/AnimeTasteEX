package com.honestme.animetasteex.login;

import android.os.AsyncTask;
import android.os.Bundle;

import com.activeandroid.ActiveAndroid;

import com.honestme.animetasteex.ATEApiUtil;
import com.honestme.animetasteex.ATEListItem;
import com.honestme.animetasteex.BaseUiPresenter;
import com.honestme.animetasteex.util.TextUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class LoginPresenter extends BaseUiPresenter<LoginPresenter.LoginUi,LoginPresenter.LoginUiCallbacks> {


    public interface LoginUi extends BaseUiPresenter.Ui<LoginUiCallbacks>{

        public void startMain();
    }

    public interface LoginUiCallbacks{
        public void login(String userName, String passWord);
    }


    @Override
    protected boolean onInited() {
        super.onInited();

        if(validCredentials()){
            mDisplay.showLoginFragment();
        }else {
            return false;
        }

        return true;

    }

    public boolean validCredentials(){
        return !TextUtil.isEmpty(mState.getUserName())
                && !TextUtil.isEmpty(mState.getHashPassword());
    }

    @Override
    protected boolean populateUi() {
        return super.populateUi();
    }

    @Override
    protected LoginUiCallbacks createUiCallBacks() {
        return new LoginUiCallbacks() {
            @Override
            public void login(String userName, String passWord) {

            }
        };
    }

    @Override
    protected boolean onSuspended() {
        mState.unRegisterForEvents(this);
        return super.onSuspended();
    }

}
