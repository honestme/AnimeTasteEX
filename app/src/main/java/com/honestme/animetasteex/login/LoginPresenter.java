package com.honestme.animetasteex.login;

import com.honestme.animetasteex.BaseUiPresenter;
import com.honestme.animetasteex.util.TextUtil;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class LoginPresenter extends BaseUiPresenter<LoginPresenter.LoginUi,LoginPresenter.LoginUiCallbacks> {


    public enum Error{
        BAD_AUTH,
        BAD_REGISTER
    }

    public interface LoginUi extends BaseUiPresenter.Ui<LoginUiCallbacks>{

        public void showLoadingProgress(boolean visible);
        public void showError(Error error);


    }

    public interface LoginUiCallbacks{
        public void login(String userName, String passWord);
        public boolean isUserEmpty(String username);
        public boolean isPasswordEmpty(String password);
        public boolean isPhoneEmpty(String phone);
        public boolean createAccount(String username,String password,String phone);
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
    protected LoginUiCallbacks createUiCallBacks() {

        return new LoginUiCallbacks() {
            @Override
            public void login(String userName, String passWord) {

            }

            @Override
            public boolean isUserEmpty(String username) {
                return username.isEmpty();
            }

            @Override
            public boolean isPasswordEmpty(String password) {
                return password.isEmpty();
            }

            @Override
            public boolean isPhoneEmpty(String phone) {
                return phone.isEmpty();
            }

            @Override
            public boolean createAccount(String username, String password, String phone) {
                return false;
            }
        };
    }

    @Override
    protected boolean onSuspended() {
        mState.unRegisterForEvents(this);
        return super.onSuspended();
    }

    @Override
    protected boolean populateUi(LoginUi ui) {
        return false;
    }

}
