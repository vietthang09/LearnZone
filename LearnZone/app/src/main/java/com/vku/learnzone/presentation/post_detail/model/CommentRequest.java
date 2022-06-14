package com.vku.learnzone.presentation.post_detail.model;

public class CommentRequest {
    private int postId;
    private String content;

    public CommentRequest() {
    }

    public CommentRequest(int postId, String content) {
        this.postId = postId;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
