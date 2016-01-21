package com.honestme.animetasteex;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseUiPresenter.HostCallbacks{

    private Context mContext;
    BaseUiPresenter mPresenter;
    ApplicationDisplay mDisplay = new ApplicationDisplay();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResource());

        handleIntent(mContext, mDisplay);
    }

    @Override
    protected void onPause() {
        mPresenter.suspend();
        mPresenter.setHostCallbacks(null);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.populateUi();
        mPresenter.setHostCallbacks(this);
    }

    protected void setPresenter(BaseUiPresenter presenter){
        mPresenter = presenter;
    }

    protected BasePresenter getPresenter(){return mPresenter;}


    protected ApplicationDisplay getDisplay(){return mDisplay;}

    protected abstract int setLayoutResource();

    protected abstract void handleIntent(Context context, ApplicationDisplay display);

}
