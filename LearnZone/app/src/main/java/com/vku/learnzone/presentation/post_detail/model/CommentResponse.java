package com.vku.learnzone.presentation.post_detail.model;

public class CommentResponse {
    private Boolean status;

    public CommentResponse() {
    }

    public CommentResponse(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
