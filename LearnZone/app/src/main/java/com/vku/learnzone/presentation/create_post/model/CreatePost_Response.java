package com.vku.learnzone.presentation.create_post.model;

public class CreatePost_Response {
    private Boolean status;

    public CreatePost_Response() {
    }

    public CreatePost_Response(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
