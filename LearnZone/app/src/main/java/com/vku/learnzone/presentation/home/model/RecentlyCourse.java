package com.vku.learnzone.presentation.home.model;

import java.io.Serializable;

public class RecentlyCourse implements Serializable {
    public int course_id;
    public String courseTitle;
    public String courseCover;
    public int user_id;
    public int teacherId;
    public String teacherName;
    public String teacherAvatar;
    public int numberOfStudents;
    public int numberOfMaterials;
    public int numberOfAssignments;

    public RecentlyCourse() {
    }

    public RecentlyCourse(int course_id, String courseTitle, String courseCover, int user_id, int teacherId, String teacherName, String teacherAvatar, int numberOfStudents, int numberOfMaterials, int numberOfAssignments) {
        this.course_id = course_id;
        this.courseTitle = courseTitle;
        this.courseCover = courseCover;
        this.user_id = user_id;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherAvatar = teacherAvatar;
        this.numberOfStudents = numberOfStudents;
        this.numberOfMaterials = numberOfMaterials;
        this.numberOfAssignments = numberOfAssignments;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCover() {
        return courseCover;
    }

    public void setCourseCover(String courseCover) {
        this.courseCover = courseCover;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public void setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfMaterials() {
        return numberOfMaterials;
    }

    public void setNumberOfMaterials(int numberOfMaterials) {
        this.numberOfMaterials = numberOfMaterials;
    }

    public int getNumberOfAssignments() {
        return numberOfAssignments;
    }

    public void setNumberOfAssignments(int numberOfAssignments) {
        this.numberOfAssignments = numberOfAssignments;
    }
}
