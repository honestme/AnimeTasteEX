package com.honestme.animetasteex.main.weekly;

import com.honestme.animetasteex.BaseUiPresenter;

/**
 * Created by Administrator on 2016/1/24 0024.
 */
public class WeeklyPresenter extends BaseUiPresenter<WeeklyPresenter.WeeklyUi,WeeklyPresenter.WeeklyUiCallbacks> {
    public interface WeeklyUi extends BaseUiPresenter.Ui<WeeklyUiCallbacks>{
    }

    public interface WeeklyUiCallbacks{}

    @Override
    protected boolean populateUi() {
        return false;
    }

    @Override
    protected WeeklyUiCallbacks createUiCallBacks() {
        return null;
    }
}
