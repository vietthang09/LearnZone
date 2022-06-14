package com.vku.learnzone.presentation.forum.model;

public class Post {
    private int authorId;
    private int postId;
    private String authorAvatar;
    private String authorName;
    private String createdAt;
    private String content;
    private String filePath;
    private int numberOfComments;

    public Post() {
    }

    public Post(int authorId, int postId, String authorAvatar, String authorName, String createdAt, String content, String filePath, int numberOfComments) {
        this.authorId = authorId;
        this.postId = postId;
        this.authorAvatar = authorAvatar;
        this.authorName = authorName;
        this.createdAt = createdAt;
        this.content = content;
        this.filePath = filePath;
        this.numberOfComments = numberOfComments;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}
