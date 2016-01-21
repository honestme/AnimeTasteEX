package com.honestme.animetasteex.login;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public interface LoginState{
    public void loginIn(String userName, String passWord, LoginCallbacks loginCallbacks);

    public String getUserName();

    public String getHashPassword();

    public interface LoginCallbacks{
        void loginSuccess();
        void loginFailed();
    }
}
