package com.honestme.animetasteex.login;

import com.honestme.animetasteex.BaseModel;

/**
 * Created by Administrator on 2015/12/14 0014.
 */
public class LoginModel extends BaseModel {
    private String mUserName;
    private String mPassWord;

    public LoginModel(String userName,String passWord){
        mUserName = userName;
        mPassWord = passWord;
    }

    private String getUserName(){
        return mUserName;
    }

    public String getPassWord() {
        return mPassWord;
    }



}
