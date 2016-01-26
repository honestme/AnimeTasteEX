package com.honestme.animetasteex.loading;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.activeandroid.ActiveAndroid;
import com.honestme.animetasteex.ATEApiUtil;
import com.honestme.animetasteex.ATEListItem;
import com.honestme.animetasteex.BaseUiPresenter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class LoadingPresenter extends
        BaseUiPresenter<LoadingPresenter.LoadingUi,LoadingPresenter.LoadingUiCallbacks> {


    public interface LoadingUi extends BaseUiPresenter.Ui<LoadingUiCallbacks>{
        public void showMainActivity();
        public void showProgress();

    }

    public interface LoadingUiCallbacks{
        public void executePrepareTask();
    }



    @Override
    protected LoadingUiCallbacks createUiCallBacks() {
        return new LoadingUiCallbacks() {
            @Override
            public void executePrepareTask() {
                Message message = new Message();
                Bundle bundle = new Bundle();
                message.setData(bundle);
                mHandlerPrepare.sendMessage(message);
            }
        };
    }

    private Handler mHandlerPrepare = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = (Bundle)msg.obj;
            PrepareTask prepareTask = new PrepareTask(bundle);
            prepareTask.execute();

        }
    };


    private class PrepareTask extends AsyncTask<Void, Void, Bundle> {
        private Bundle mBundle;

        @Override
        protected void onPostExecute(Bundle result) {
            super.onPostExecute(result);
        }

        public PrepareTask(Bundle bundle) {
            super();
            mBundle = bundle;
        }

        @Override
        protected Bundle doInBackground(Void... params) {


            try {
                ActiveAndroid.beginTransaction();
                ArrayList<ATEListItem> listItemsMain = ATEApiUtil.getDataFromUriMain(ATEApiUtil.ATE_MAIN, 1);
                ArrayList<ATEListItem> listItemsInterview = ATEApiUtil.getDataFromUriMain(ATEApiUtil.ATE_INTERVIEW, 1);
                ArrayList<ATEListItem> listItemsWeekly = ATEApiUtil.getDataFromUriMain(ATEApiUtil.ATE_WEEKLY_INSPIRATIONS, 1);

                for (int i = 0; i < listItemsMain.size(); i++) {
                    listItemsMain.get(i).save();
                }

                for (int i = 0; i < listItemsInterview.size(); i++) {
                    listItemsInterview.get(i).save();
                }

                for (int i = 0; i < listItemsWeekly.size(); i++) {
                    listItemsWeekly.get(i).save();
                }

                mBundle.putParcelableArrayList("main", listItemsMain);
                mBundle.putParcelableArrayList("interview", listItemsInterview);
                mBundle.putParcelableArrayList("weekly", listItemsWeekly);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                ActiveAndroid.setTransactionSuccessful();
                ActiveAndroid.endTransaction();
            }


            return mBundle;
        }
    }

    @Override
    protected boolean populateUi(LoadingUi ui) {
        return false;
    }
}
