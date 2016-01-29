package com.honestme.animetasteex.main.primary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.honestme.animetasteex.MainListItem;
import com.honestme.animetasteex.R;

import java.util.List;

/**
 * Created by zhangconglin on 2016/1/11.
 */
public class PrimaryFragment extends android.support.v4.app.Fragment implements PrimaryPresenter.PrimaryUi{

    private int mSubjectType;
    private ListView mListView;



    public PrimaryFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_ate_main_fragment,container);
        mListView = (ListView)view.findViewById(R.id.app_ate_main_fragment_listview);
        return view;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void setCollection(List<MainListItem> collection) {

    }

    @Override
    public void setCallBack(PrimaryPresenter.PrimaryUiCallBacks callbacks) {

    }
}
