package com.honestme.animetasteex;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.viewpagerindicator.TabPageIndicator;

public class ATEMainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private TabPageIndicator mPageIndicator;
    private ATETabAdapter mTabAdapter;



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
                ATEApiTest test = new ATEApiTest();
                test.createTestMain(ATEApiUtil.ATE_MAIN, 2);
                test.createTestAMZ(ATEApiUtil.ATE_AMZ_CATEGORY_ADVERTISE,2 );
            }
        }).start();


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
}
