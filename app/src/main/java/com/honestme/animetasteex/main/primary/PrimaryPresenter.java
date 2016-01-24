package com.honestme.animetasteex.main.primary;



import com.google.common.eventbus.Subscribe;
import com.honestme.animetasteex.ATEListItem;
import com.honestme.animetasteex.BaseUiPresenter;

import java.util.List;

/**
 * Created by Administrator on 2015/11/27 0027.
 */
public class PrimaryPresenter extends BaseUiPresenter<PrimaryPresenter.PrimaryUi,PrimaryPresenter.PrimaryUiCallBacks> {

    public interface PrimaryUi extends BaseUiPresenter.Ui<PrimaryUiCallBacks>{
        void setCollection(List<ATEListItem> collection);
    }

    public interface PrimaryUiCallBacks {}

    private final PrimaryUiCallBacks mPrimaryUiCallBacks = new PrimaryUiCallBacks() {
    };


    @Override
    protected boolean onInited() {
        super.onInited();

        mState.registerForEvents(this);
        return true;
    }


    @Override
    protected PrimaryUiCallBacks createUiCallBacks() {
        return mPrimaryUiCallBacks;
    }



    @Subscribe
    public void collectionChange(PrimaryState.CollectionChangedEvent collectionChangedEvent){
        populateUi();
    }

}

