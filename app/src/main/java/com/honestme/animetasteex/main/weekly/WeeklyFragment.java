package com.honestme.animetasteex.main.weekly;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.honestme.animetasteex.R;

/**
 * Created by Administrator on 2016/1/21 0021.
 */
public class WeeklyFragment extends android.support.v4.app.Fragment {
    private Context mContext = getContext();
    private final String TAG = getClass().getSimpleName();
    private ListView mListView;

    public WeeklyFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weekly,container);
        mListView = (ListView)view.findViewById(R.id.fragment_weekly_list);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
