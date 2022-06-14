package com.vku.learnzone.presentation.create_post.model;

import android.net.Uri;

import okhttp3.MultipartBody;

public class CreatePost_Request {
    private String content;

    public CreatePost_Request() {
    }

    public CreatePost_Request(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
