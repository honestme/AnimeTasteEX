package com.honestme.animetasteex;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/10 0010.
 */
public class HonestmeViewHolder {
    private SparseArray<View> mSparseArray;
    private View mConvertView;

    public HonestmeViewHolder(Context context,ViewGroup viewGroup,int layoutId){
        mSparseArray = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId,viewGroup);
        mConvertView.setTag(this);
    }

    public static HonestmeViewHolder getViewHolder(Context context,View convertView,ViewGroup viewGroup,int layoutId){

        if(convertView == null){
            return new HonestmeViewHolder(context,viewGroup,layoutId);
        }

        return (HonestmeViewHolder)convertView.getTag();
    }

    public void setItems(SparseArray<View> sparseArray){
        mSparseArray = sparseArray;
    }

    public View findView(int resourceId){
        View view = mSparseArray.get(resourceId);

        if(view == null){
            view = mConvertView.findViewById(resourceId);
            mSparseArray.put(resourceId,view);
        }
        return view;
    }

    public View getConvertView(){
        return mConvertView;
    }

    public HonestmeViewHolder populateTextView(int resourceId,String text){
        TextView textView = (TextView)findView(resourceId);
        textView.setText(text);
        return this;
    }

    public HonestmeViewHolder populateImageView(int resourceId,int imageId){
        ImageView imageView = (ImageView)findView(resourceId);
        imageView.setImageResource(imageId);
        return this;
    }
}
