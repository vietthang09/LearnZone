package com.vku.learnzone.presentation.course_detail.model;

public class CourseResponse {
    private Course course;

    public CourseResponse() {
    }

    public CourseResponse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
