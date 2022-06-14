package com.vku.learnzone.presentation.post_detail.model;

public class PostResponse {
    private Post post;

    public PostResponse() {
    }

    public PostResponse(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
