package com.vku.learnzone.presentation.course_detail.model;

public class CourseRequestBody {
    private int id;

    public CourseRequestBody() {
    }

    public CourseRequestBody(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
