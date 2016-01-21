package com.honestme.animetasteex;

import com.google.common.base.Preconditions;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class BasePresenter {

        private boolean mInited;
        protected ApplicationDisplay mDisplay;
        protected ApplicationState mState;

        public BasePresenter(){
            mDisplay = new ApplicationDisplay();
            mState = ApplicationState.getInstance();
        }


        public final BaseDisplay getDisplay(){
            return mDisplay;
        }

        public boolean init(){
            Preconditions.checkState(mInited == false, "Already inited");
            mInited = true;
            return onInited();
        }

        public boolean suspend(){
            Preconditions.checkState(mInited == true,"Not inited");

            mInited = false;
            return onSuspended();

        }

        public boolean isInited(){
            return mInited;
        }

        protected boolean onInited(){return true;}
        protected boolean onSuspended(){return true;}
}
