package com.vku.learnzone.presentation.post_detail.model;

public class Post {
    public int authorId;
    public String authorAvatar;
    public String authorName;
    public String image;
    public String content;
    public String createdAt;

    public Post() {
    }

    public Post(int authorId, String authorAvatar, String authorName, String image, String content, String createdAt) {
        this.authorId = authorId;
        this.authorAvatar = authorAvatar;
        this.authorName = authorName;
        this.image = image;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
