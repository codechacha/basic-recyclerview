package com.example.recyclerview;

import android.graphics.drawable.Drawable;

public class SampleItem {
    private String title;
    private Drawable thumbnail;

    public SampleItem(String title, Drawable thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Drawable thumbnail) {
        this.thumbnail = thumbnail;
    }
}
