package com.honestme.animetasteex.main;

import com.honestme.animetasteex.BaseUiPresenter;
import com.honestme.animetasteex.main.primary.PrimaryPresenter;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class MainPresenter extends BaseUiPresenter<MainPresenter.MainUi,MainPresenter.MainUiCallbacks> {

    public interface MainUi extends BaseUiPresenter.Ui<MainUiCallbacks>{

    }

    public interface MainUiCallbacks{}

    private PrimaryPresenter moviePresenter;
    private MainUiCallbacks mMainUiCallbacks;

    public MainPresenter(){
        moviePresenter = new PrimaryPresenter();
    }

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
}
