package com.honestme.animetasteex.main.interview;

import com.honestme.animetasteex.BaseUiPresenter;

/**
 * Created by Administrator on 2016/1/21 0021.
 */
public class InterviewPresenter extends BaseUiPresenter<InterviewPresenter.InterviewUi,InterviewPresenter.InterviewUiCallback>{
    public interface InterviewUi extends BaseUiPresenter.Ui<InterviewUiCallback>{}

    public interface InterviewUiCallback{}

    @Override
    protected InterviewUiCallback createUiCallBacks() {
        return null;
    }


}
