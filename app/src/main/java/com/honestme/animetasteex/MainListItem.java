package com.honestme.animetasteex;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by zhangconglin on 2016/1/11.
 */
@Table(name = "MainListItem")
public class MainListItem extends Model implements Parcelable {
    @Column(name = "id")
    private int mId;
    @Column(name = "type")
    private int mType;
    @Column(name = "page")
    private int mPage;
    @Column(name = "title")
    private String mTitle;
    @Column(name = "content")
    private String mContent;
    @Column(name = "contentLink")
    private String mContentLink;
    @Column(name = "imageUrl")
    private String mImageUrl;
    @Column(name = "viewTimes")
    private String mViewTimes;
    @Column(name = "author")
    private String mAuthor;
    @Column(name = "animeTitle")
    private String mAnimeTitle;




    public void setId(int id) {
        mId = id;
    }


    public int getmId() {
        return mId;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public int getPage() {
        return mPage;
    }

    public void setPage(int page) {
        mPage = page;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getContentLink() {
        return mContentLink;
    }

    public void setContentLink(String contentLink) {
        mContentLink = contentLink;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getViewTimes() {
        return mViewTimes;
    }

    public void setViewTimes(String viewTimes) {
        mViewTimes = viewTimes;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getAnimeTitle() {
        return mAnimeTitle;
    }

    public void setAnimeTitle(String animeTitle) {
        mAnimeTitle = animeTitle;
    }

    @Override
    public String toString() {
        return "title:"+mTitle + ",content:" + mContent + ",contentlink:" + mContentLink +
                ",viewTimes:" + mViewTimes + ",author:"+ mAuthor + ",animetitle:" + mAnimeTitle
                ;
    }

    public MainListItem() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
       dest.writeInt(this.mType);
        dest.writeInt(this.mPage);
        dest.writeString(this.mTitle);
        dest.writeString(this.mContent);
        dest.writeString(this.mContentLink);

        dest.writeString(this.mImageUrl);

        dest.writeString(this.mViewTimes);
        dest.writeString(this.mAuthor);
        dest.writeString(this.mAnimeTitle);
    }

    protected MainListItem(Parcel in) {
        this.mId = in.readInt();
        this.mType = in.readInt();
        this.mPage = in.readInt();
        this.mTitle = in.readString();
        this.mContent = in.readString();
        this.mContentLink = in.readString();


        this.mImageUrl = in.readString();

        this.mViewTimes = in.readString();
        this.mAuthor = in.readString();
        this.mAnimeTitle = in.readString();
    }

    public static final Creator<MainListItem> CREATOR = new Creator<MainListItem>() {
        public MainListItem createFromParcel(Parcel source) {
            return new MainListItem(source);
        }

        public MainListItem[] newArray(int size) {
            return new MainListItem[size];
        }
    };
}
