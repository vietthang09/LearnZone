package com.vku.learnzone.presentation.post_detail.model;

import java.util.ArrayList;

public class Comments {
    private ArrayList<Comment> comments;

    public Comments() {
    }

    public Comments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
