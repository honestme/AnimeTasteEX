package com.honestme.animetasteex.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.honestme.animetasteex.ATETabAdapter;
import com.honestme.animetasteex.ApiTest;
import com.honestme.animetasteex.ApiUtil;
import com.honestme.animetasteex.ApplicationDisplay;
import com.honestme.animetasteex.BaseActivity;
import com.honestme.animetasteex.R;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener,MainPresenter.MainUi{

    private ViewPager mViewPager;
    private TabPageIndicator mPageIndicator;
    private ATETabAdapter mTabAdapter;

    private Context mContext = MainActivity.this;

    private MainPresenter.MainUiCallbacks mUiCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_ate_main_activity);
        mTabAdapter = new ATETabAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager)findViewById(R.id.app_ate_main_viewpaper);
        mPageIndicator = (TabPageIndicator)findViewById(R.id.app_ate_main_indicator);
        mViewPager.setAdapter(mTabAdapter);
        mPageIndicator.setViewPager(mViewPager);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setCurrentItem(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiTest test = new ApiTest();
                test.createTestMain(ApiUtil.ATE_MAIN, 2);
                test.createTestAMZ(ApiUtil.ATE_AMZ_CATEGORY_ADVERTISE,2 );
            }
        }).start();


    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void handleIntent(Context context, ApplicationDisplay display) {
        if(display.hasMainFragment()){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void setCallBack(MainPresenter.MainUiCallbacks callbacks) {
        mUiCallbacks = callbacks;
    }

    public static void actionStartIntent(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
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
}
