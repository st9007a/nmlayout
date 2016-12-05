package com.nm.nmlayout.nmlayout;

import android.graphics.Bitmap;

public class Notification {

    private String title;
    private String text;
    private String postTime;
    private Bitmap icon;

    public Notification() {
        title = "JM Wu";
        text = "hello ~";
        postTime = "00:10";
    }
    public Notification(String title, String text, String postTime) {
        this.title = title;
        this.text = text;
        this.postTime = postTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public Bitmap getIcon() {
        return icon;
    }
}
