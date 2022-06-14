package com.vku.learnzone.presentation.course_detail.model;

public class Course {
    public int teacherId;
    public String courseCover;
    public String courseTitle;
    public String courseIntroduction;
    public String teacherAvatar;
    public String teacherName;

    public Course() {
    }

    public Course(int teacherId, String courseCover, String courseTitle, String courseIntroduction, String teacherAvatar, String teacherName) {
        this.teacherId = teacherId;
        this.courseCover = courseCover;
        this.courseTitle = courseTitle;
        this.courseIntroduction = courseIntroduction;
        this.teacherAvatar = teacherAvatar;
        this.teacherName = teacherName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseCover() {
        return courseCover;
    }

    public void setCourseCover(String courseCover) {
        this.courseCover = courseCover;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseIntroduction() {
        return courseIntroduction;
    }

    public void setCourseIntroduction(String courseIntroduction) {
        this.courseIntroduction = courseIntroduction;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public void setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
