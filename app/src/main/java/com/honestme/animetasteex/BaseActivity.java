package com.honestme.animetasteex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.honestme.animetasteex.main.MainPresenter;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseUiPresenter.HostCallbacks{

    private Context mContext;
    BaseUiPresenter mPresenter;
    private DrawerLayout mDrawerLayout;
    private MainPresenter mMainPresenter;
    private View mViewContainer;

    ApplicationDisplay mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResource());

        mDrawerLayout = (DrawerLayout)findViewById(R.id.main_drawer);
        mViewContainer = findViewById(R.id.card_container);
        mDisplay = new ApplicationDisplay(mContext,mDrawerLayout);
        mMainPresenter = BaseApplication.from(mContext).getMainPresenter();

        handleIntent(mContext, mDisplay);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(mContext,mDisplay);
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
        mPresenter.populateUi(mPresenter.getUi());
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
