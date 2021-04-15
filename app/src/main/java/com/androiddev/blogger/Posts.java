package com.androiddev.blogger;

import java.util.Date;

public class Posts {
    private String date;
    private String mainTitle;
    private String tags;
    private String author;
    private String mainText;

    public Posts(String date, String mainTitle, String tags, String author, String mainText) {
        this.date = date;
        this.mainTitle = mainTitle;
        this.tags = tags;
        this.author = author;
        this.mainText = mainText;
    }

    public String getDate() {
        return date;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getMainText() {
        return mainText;
    }
}
