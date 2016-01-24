package com.honestme.animetasteex;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.honestme.animetasteex.commit.CommitDisplay;
import com.honestme.animetasteex.loading.LoadingDisplay;
import com.honestme.animetasteex.login.LoginDisplay;
import com.honestme.animetasteex.main.MainDisplay;
import com.honestme.animetasteex.main.interview.InterviewFragment;
import com.honestme.animetasteex.main.primary.PrimaryFragment;
import com.honestme.animetasteex.main.weekly.WeeklyFragment;

/**
 * Created by Administrator on 2016/1/13 0013.
 */
public class ApplicationDisplay implements LoginDisplay,MainDisplay,CommitDisplay,LoadingDisplay{
    private Context mContext;
    private AppCompatActivity mActivity;
    private DrawerLayout mDrawerLayout;

    public ApplicationDisplay(Context context,DrawerLayout drawerLayout){
        mContext = context;
        mDrawerLayout = drawerLayout;

    }

    @Override
    public boolean popUpStackFragments() {
        int fragmentCount = mActivity.getSupportFragmentManager().getBackStackEntryCount();

        for(int i = 0;i < fragmentCount;i++){
            mActivity.getSupportFragmentManager().popBackStack();
        }

        return fragmentCount == 0;
    }

    @Override
    public void showLoginFragment() {

    }

    @Override
    public void startMainActivity() {

    }

    @Override
    public boolean hasMainFragment() {
        return (mActivity.getSupportFragmentManager().findFragmentById(R.id.main_fragment) != null);
    }

    @Override
    public void showFragment(Fragment fragment) {
        mActivity.getSupportFragmentManager().beginTransaction().replace(R.id.card_container,fragment).commit();
    }

    @Override
    public void showFragmentWithDrawer(Fragment fragment) {
        popUpStackFragments();
        showFragment(fragment);
    }

    @Override
    public void showPrimaryFragment() {
        showFragment(new PrimaryFragment());
    }

    @Override
    public void showWeeklyFragment() {
        showFragment(new WeeklyFragment());
    }

    @Override
    public void showInterviewFragment() {
        showFragment(new InterviewFragment());
    }
}
