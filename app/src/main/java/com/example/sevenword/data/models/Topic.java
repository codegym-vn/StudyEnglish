package com.example.sevenword.data.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TienBM on 12/16/2017.
 */

public class Topic {
    private int mId;
    private int mCover;
    private String mTitle;
    private String mDescription;
    private List<Word> mWords = new ArrayList<>();

    public Topic() {
    }

    public Topic(int id, String title,String description,int cover) {
        mId = id;
        mTitle = title;
        mDescription = description;
        mCover = cover;
    }


    public Topic(int id, String title, List<Word> words) {
        mId = id;
        mTitle = title;
        mWords = words;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getCover() {
        return mCover;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public List<Word> getWords() {
        return mWords;
    }

    public void setWords(List<Word> words) {
        mWords = words;
    }
}
