package com.honestme.animetasteex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/10 0010.
 */
public abstract class HonestmeAdapter<T> extends BaseAdapter {
    private Context mContext;
    private List<T> mItems = new ArrayList<T>();
    private int mResourceId;

    public HonestmeAdapter(Context context,List<T> items,int resourceId){
        mContext = context;
        mItems = items;
        mResourceId = resourceId;
    }

    public void setItems(List<T> items){
        mItems = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HonestmeViewHolder viewHolder = HonestmeViewHolder.getViewHolder(mContext,convertView,parent,mResourceId);
        populateUi(viewHolder,(T)getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void populateUi(HonestmeViewHolder viewHolder,T item);
}
