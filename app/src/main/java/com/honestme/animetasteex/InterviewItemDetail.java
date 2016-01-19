package com.honestme.animetasteex;

import java.util.List;

/**
 * Created by zhangconglin on 2016/1/18.
 */
public class InterviewItemDetail {
    private String mAnimeLink;
    private String mTitle;
    private String mAuthorLink;
    private String mAuthor;
    private List<String> mImageUrlList;
    private List<interview> mInterviewList;

    public String getAnimeLink() {
        return mAnimeLink;
    }

    public void setAnimeLink(String animeLink) {
        mAnimeLink = animeLink;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthorLink() {
        return mAuthorLink;
    }

    public void setAuthorLink(String authorLink) {
        mAuthorLink = authorLink;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public List<String> getImageUrlList() {
        return mImageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        mImageUrlList = imageUrlList;
    }

    private class interview{
        private String mQuestion;
        private String mResponse;

        public String getQuestion() {
            return mQuestion;
        }

        public void setQuestion(String question) {
            mQuestion = question;
        }

        public String getResponse() {
            return mResponse;
        }

        public void setResponse(String response) {
            mResponse = response;
        }
    }


}
