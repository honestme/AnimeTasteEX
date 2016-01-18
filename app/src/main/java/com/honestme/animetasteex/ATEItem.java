package com.honestme.animetasteex;

/**
 * Created by zhangconglin on 2016/1/11.
 */
public class ATEItem {
    private int mId;
    private int mPage;
    private String mTitle;
    private String mContent;
    private String mContentLink;
    private String mAnimeContent;
    private String mAnimeLink;
    private String mImageUrl;
    private String mAnimeImageUrl;
    private String mViewTimes;
    private String mAuthor;
    private String mAnimeTitle;

    public String getmAnimeTitle() {
        return mAnimeTitle;
    }

    public void setmAnimeTitle(String mAnimeTitle) {
        this.mAnimeTitle = mAnimeTitle;
    }

    public String getmViewTimes() {
        return mViewTimes;
    }

    public void setmViewTimes(String mViewTimes) {
        this.mViewTimes = mViewTimes;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmPage() {
        return mPage;
    }

    public void setmPage(int mPage) {
        this.mPage = mPage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmContentLink() {
        return mContentLink;
    }

    public void setmContentLink(String mContentLink) {
        this.mContentLink = mContentLink;
    }

    public String getmAnimeContent() {
        return mAnimeContent;
    }

    public void setmAnimeContent(String mAnimeContent) {
        this.mAnimeContent = mAnimeContent;
    }

    public String getmAnimeLink() {
        return mAnimeLink;
    }

    public void setmAnimeLink(String mAnimeLink) {
        this.mAnimeLink = mAnimeLink;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmAnimeImageUrl() {
        return mAnimeImageUrl;
    }

    public void setmAnimeImageUrl(String mAnimeImageUrl) {
        this.mAnimeImageUrl = mAnimeImageUrl;
    }

    @Override
    public String toString() {
        return "title:"+mTitle + ",content:" + mContent + ",contentlink:" + mContentLink +
                ",viewTimes:" + mViewTimes + ",author:"+ mAuthor + ",animetitle:" + mAnimeTitle+
                ",animecontent:"+mAnimeContent + ",animelink"+mAnimeLink;
    }
}
