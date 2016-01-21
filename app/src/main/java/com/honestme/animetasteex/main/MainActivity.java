package com.honestme.animetasteex.main;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.honestme.animetasteex.ApplicationDisplay;
import com.honestme.animetasteex.BaseActivity;
import com.honestme.animetasteex.BaseDisplay;
import com.honestme.animetasteex.R;

public class MainActivity extends BaseActivity implements MainPresenter.MainUi {

    private Context mContext = MainActivity.this;

    private MainPresenter mMainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter = new MainPresenter();
        setPresenter(mMainPresenter);

    }

    @Override
    protected void handleIntent(Context context, ApplicationDisplay display) {

    }

    @Override
    public void setCallBack(MainPresenter.MainUiCallbacks callbacks) {

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(mContext);
        menuInflater.inflate(R.menu.menus,menu);

        MenuItem item = menu.findItem(R.id.main_menu_share);
        ShareActionProvider actionProvider = (ShareActionProvider)item.getActionProvider();
        Intent intent = new Intent();

        actionProvider.setShareIntent(intent);

        return true;
    }





    public static void actionStartIntent(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }



}
