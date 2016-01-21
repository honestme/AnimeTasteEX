package com.honestme.animetasteex;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by zhangconglin on 2016/1/15.
 */
@Table(name = "AmzItem")
public class AMZListItem extends Model implements Parcelable {
    @Column(name = "id")
    private int mId;
    @Column(name = "imageUrl")
    private String mImageUrl;
    @Column(name = "link")
    private String mLink;
    @Column(name = "topContent")
    private String mTopContent;
    @Column(name = "date")
    private String mDate;
    @Column(name = "bottomContent")
    private String mBottomContent;
    @Column(name = "bottomImageUrl")
    private String mBottomImageUrl;
    @Column(name = "viewTimes")
    private String mViewTimes;

    public AMZListItem() {
        super();
    }

    public String getmViewTimes() {
        return mViewTimes;
    }

    public void setmViewTimes(String mViewTimes) {
        this.mViewTimes = mViewTimes;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmTopContent() {
        return mTopContent;
    }

    public void setmTopContent(String mTopContent) {
        this.mTopContent = mTopContent;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmBottomContent() {
        return mBottomContent;
    }

    public void setmBottomContent(String mBottomContent) {
        this.mBottomContent = mBottomContent;
    }

    public String getmBottomImageUrl() {
        return mBottomImageUrl;
    }

    public void setmBottomImageUrl(String mBottomImageUrl) {
        this.mBottomImageUrl = mBottomImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.mImageUrl);
        dest.writeString(this.mLink);
        dest.writeString(this.mTopContent);
        dest.writeString(this.mDate);
        dest.writeString(this.mBottomContent);
        dest.writeString(this.mBottomImageUrl);
        dest.writeString(this.mViewTimes);
    }

    protected AMZListItem(Parcel in) {
        this.mId = in.readInt();
        this.mImageUrl = in.readString();
        this.mLink = in.readString();
        this.mTopContent = in.readString();
        this.mDate = in.readString();
        this.mBottomContent = in.readString();
        this.mBottomImageUrl = in.readString();
        this.mViewTimes = in.readString();
    }

    public static final Parcelable.Creator<AMZListItem> CREATOR = new Parcelable.Creator<AMZListItem>() {
        public AMZListItem createFromParcel(Parcel source) {
            return new AMZListItem(source);
        }

        public AMZListItem[] newArray(int size) {
            return new AMZListItem[size];
        }
    };
}
