package com.honestme.animetasteex.main;

import com.honestme.animetasteex.ApplicationState;
import com.honestme.animetasteex.BaseUiPresenter;
import com.honestme.animetasteex.main.interview.InterviewFragment;
import com.honestme.animetasteex.main.primary.PrimaryPresenter;
import com.honestme.animetasteex.main.weekly.WeeklyPresenter;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class MainPresenter extends BaseUiPresenter<MainPresenter.MainUi,MainPresenter.MainUiCallbacks> {


    private PrimaryPresenter mPrimaryPresenter;
    private WeeklyPresenter mWeeklyPresenter;
    private InterviewFragment mInterviewFragment;

    private ApplicationState mState;



    public enum  SlideMenu{

        PRIMARY
    }

    public void setSelectSlideMenuItem(SlideMenu menuItem){
        getState().setSelectSlideItem(menuItem);
        populateUiset();
    }

    public interface MainUi extends BaseUiPresenter.Ui<MainUiCallbacks>{

    }

    public interface MainUiCallbacks{}

    private PrimaryPresenter moviePresenter;
    private MainUiCallbacks mMainUiCallbacks;

    public MainPresenter(){
        moviePresenter = new PrimaryPresenter();

    }

    public ApplicationState getState(){return mState;}

    public PrimaryPresenter getMoviePresenter(){
        return moviePresenter;
    }

    @Override
    protected boolean onInited() {
        return moviePresenter.init();
    }

    @Override
    protected MainUiCallbacks createUiCallBacks() {
        return new MainUiCallbacks() {
        };
    }

    @Override
    protected boolean onSuspended() {

        return moviePresenter.suspend();

    }

    @Override
    protected boolean populateUi(MainUi ui) {
        return false;
    }
}
