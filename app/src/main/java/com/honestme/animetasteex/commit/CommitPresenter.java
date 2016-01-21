package com.honestme.animetasteex.commit;

import com.honestme.animetasteex.BaseUiPresenter;

/**
 * Created by Administrator on 2015/12/14 0014.
 */
public class CommitPresenter extends BaseUiPresenter<CommitPresenter.CommitUi,
        CommitPresenter.CommitUiCallBacks> {


    public interface CommitUi extends BaseUiPresenter.Ui<CommitUiCallBacks>{}

    public interface CommitUiCallBacks{}

    @Override
    protected CommitUiCallBacks createUiCallBacks() {
        return new CommitUiCallBacks() {
        };
    }


}
