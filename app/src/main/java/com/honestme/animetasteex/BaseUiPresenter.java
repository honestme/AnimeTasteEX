package com.honestme.animetasteex;

import com.google.common.base.Preconditions;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Administrator on 2015/11/27 0027.
 */
public abstract class BaseUiPresenter<U extends BaseUiPresenter.Ui<UC>,UC>
        extends BasePresenter {

    public interface Ui<UC>{
        public void setCallBack(UC callbacks);
    }

    protected interface HostCallbacks{}

    private U mUi;
    private UC mUiCallbacks;


    private HostCallbacks mHostCallbacks;

    private  Set<U> mUiSet;

    public BaseUiPresenter() {
        mUiCallbacks = createUiCallBacks();
        mUiSet = new CopyOnWriteArraySet<>();
    }


    protected void setHostCallbacks(HostCallbacks hostCallbacks){
        mHostCallbacks = hostCallbacks;
    }

    public final void attachUi(U ui){
        Preconditions.checkState(mUi == null,"UI is already attached");
        Preconditions.checkArgument(mUi != null,"UI can't be null");
        mUi = ui;
        mUi.setCallBack(createUiCallBacks());

        mUiSet.add(mUi);

        if(isInited()){
            onUiAttached(ui);
            populateUi(ui);
        }
    }

    public final void detachUi(U ui){
        Preconditions.checkArgument(ui != null,"ui can't be null");
        Preconditions.checkState(mUi == ui, "UI is not attached");
        onUiDetached(ui);
        mUiSet.remove(ui);
        mUi.setCallBack(null);
        mUi = null;
    }

    protected final U getUi(){
        return mUi;
    }

    protected void onUiAttached(U ui){}

    protected void onUiDetached(U ui){};

    protected boolean onInited(){
       if(!mUiSet.isEmpty()){
           for (U ui:mUiSet){
               onUiAttached(ui);
               populateUi(ui);
           }
       }

        return true;
    }

    protected abstract boolean populateUi(U ui);

    protected  void populateUiset(){
        for(U ui:mUiSet){
            populateUi(ui);
        }
    }

    protected abstract UC createUiCallBacks();
}
