package com.example.sevenword.data.models;

/**
 * Created by TienBM on 12/16/2017.
 */

public class Word {
    private String title;
    private String mean;

    public Word() {
    }

    public Word(String title, String mean) {
        this.title = title;
        this.mean = mean;
    }


    public String getMean() {
        return mean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
