package com.example.newsapplication;

import java.io.Serializable;

public class News implements Serializable {
    private String imageUrl;
    private String title;
    private String contentUrl;

    public News(String imageUrl, String title, String contentUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.contentUrl = contentUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
}
